package com.epam.uni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * test configuration class
 *
 * @author bakhridinova
 */

@Configuration
@ComponentScan(lazyInit = true)
public class TestConfig {
    @Bean
    public String dishFilePath() {
        return "src/test/resources/csv/dishes.csv";
    }

    @Bean
    public String linenFilePath() {
        return "src/test/resources/csv/linens.csv";
    }
}
