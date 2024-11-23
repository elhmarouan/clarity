package com.clarity.autoconfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomAnnotationsBeanRegistrar.class)
public class CustomAnnotationsBeanAutoConfiguration {
}