package com.clarity.autoconfigure;

import com.clarity.domain.annotations.UseCase;
import com.clarity.infrastructure.annotations.PersistenceRepository;
import java.lang.annotation.Annotation;
import java.util.Set;
import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class CustomAnnotationsBeanRegistrar implements ImportBeanDefinitionRegistrar {

  private static final Class<? extends Annotation>[] ANNOTATIONS_TO_SCAN = new Class[]{
      UseCase.class,
      PersistenceRepository.class
  };

  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    final Reflections reflections = new Reflections("com.clarity");

    for (Class<? extends Annotation> annotation : ANNOTATIONS_TO_SCAN) {
      final Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotation);

      for (Class<?> clazz : annotatedClasses) {
        final GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(clazz);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

        // Register the bean with its name in lowercase
        final String beanName = generateBeanName(clazz);
        registry.registerBeanDefinition(beanName, beanDefinition);
      }
    }
  }

  private static String generateBeanName(final Class<?> clazz) {
    return clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1);
  }
}