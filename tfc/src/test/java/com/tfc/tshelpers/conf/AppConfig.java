package com.tfc.tshelpers.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class AppConfig {   

    // Required to enable @Value annotations to resolve properties from .properties files
    // Automatically converts property values from String to the appropriate type
    @Bean
     public static PropertySourcesPlaceholderConfigurer propertyConfig() {

        return new PropertySourcesPlaceholderConfigurer();
    }
}