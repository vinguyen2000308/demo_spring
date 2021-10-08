package com.example.demo_spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({Item.class, ConfigCredentialsProperties.class})
public class DemoSpringApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSpringApplication.class);

    @Autowired
    private Item item;


    @Autowired
    private ConfigCredentialsProperties configCredentialsProperties;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

    @Bean
    public ConfigCredentialsProperties configCredentialsProperties() {
        return new ConfigCredentialsProperties();

    }

    @Bean
    public Item getItemConfig() {
        return new Item();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Credentials Config...");
        LOGGER.info(String.valueOf(configCredentialsProperties));
        System.out.println("Item Config...");
        LOGGER.info(String.valueOf(item));
        for (int i = 0; i < 100; i++) {
            LOGGER.info("Log: " + i);
        }
    }
    // Using @ConfigurationProperties on a @Bean method
    // Create Nested Configuration
    // Create Immutable with @ConfigurationProperties Binding
        // Using @ConfigurationProperties, @ConstructorBinding and constructor with all the parameters

}
