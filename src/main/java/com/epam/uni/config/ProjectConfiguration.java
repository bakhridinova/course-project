package com.epam.uni.config;

import com.epam.uni.entity.Dish;
import com.epam.uni.entity.Linen;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * main configuration class
 *
 * @author bakhridinova
 */

@Configuration
@ComponentScan(basePackages = "com.epam.uni")
public class ProjectConfiguration {
    @Bean
    public String dishFilePath() {
        return "src/main/resources/csv/dishes.csv";
    }

    @Bean
    public String linenFilePath() {
        return "src/main/resources/csv/linens.csv";
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CsvToBeanBuilder<Dish> dishBeanBuilder(String dishFilePath) {
        FileReader dishFileReader;
        try {
            dishFileReader = new FileReader(dishFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new CsvToBeanBuilder<>(dishFileReader);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CsvToBeanBuilder<Linen> linenBeanBuilder(String linenFilePath) {
        FileReader linenFileReader;
        try {
            linenFileReader = new FileReader(linenFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new CsvToBeanBuilder<>(linenFileReader);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
