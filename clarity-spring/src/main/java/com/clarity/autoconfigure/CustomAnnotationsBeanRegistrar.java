package com.clarity.autoconfigure;

import java.lang.annotation.Annotation;
import java.util.Set;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

public class CustomAnnotationsBeanRegistrar implements ImportBeanDefinitionRegistrar,
    EnvironmentAware {
  private static final Logger logger = LoggerFactory.getLogger(CustomAnnotationsBeanRegistrar.class);

  private Environment environment;

  @Override
  public void setEnvironment(@NonNull final Environment environment) {
    this.environment = environment;
  }

  @Override
  public void registerBeanDefinitions(@NonNull AnnotationMetadata importingClassMetadata, @NonNull BeanDefinitionRegistry registry) {
    final String mainPackage = environment.getProperty("clarity.scan.base-package");
    final Class<? extends Annotation>[] annotationsToScan = getAnnotationsToScan();

    final Reflections reflections = new Reflections(mainPackage);

    logger.info("Scanning for classes annotated with {} annotations...", annotationsToScan.length);
    for (Class<? extends Annotation> annotation : annotationsToScan) {
      final Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotation);

      for (Class<?> clazz : annotatedClasses) {
        final GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(clazz);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

        final String beanName = generateBeanName(clazz);
        registry.registerBeanDefinition(beanName, beanDefinition);
        logger.info("Registered bean: {} for class: {}", beanName, clazz.getName());
      }
    }
  }

  private static String generateBeanName(final Class<?> clazz) {
    return clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1);
  }

  private Class<? extends Annotation>[] getAnnotationsToScan() {
    final String[] annotationNames = environment.getProperty("clarity.scan.annotations", "").split(",");

    @SuppressWarnings("unchecked")
    final Class<? extends Annotation>[] result = new Class[annotationNames.length];

    for (int i = 0; i < annotationNames.length; i++) {
      String name = annotationNames[i].trim();
      if (name.isEmpty()) continue;
      try {
        Class<?> clazz = Class.forName(name);
        if (!Annotation.class.isAssignableFrom(clazz)) {
          throw new IllegalArgumentException(name + " is not an annotation type");
        }
        result[i] = (Class<? extends Annotation>) clazz;
      } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException("Annotation not found " + name, e);
      }
    }
    return result;
  }
}