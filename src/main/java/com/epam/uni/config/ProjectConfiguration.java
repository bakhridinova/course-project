package com.epam.uni.config;

import com.epam.uni.entity.Dish;
import com.epam.uni.entity.Linen;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public ColumnPositionMappingStrategy<Dish> dishMappingStrategy() {
        ColumnPositionMappingStrategy<Dish> mappingStrategy =
                new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Dish.class);
        String[] columns = new String[]
                {"id", "size", "price", "description",
                        "left_in_stock", "category", "material"};
        mappingStrategy.setColumnMapping(columns);
        return mappingStrategy;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StatefulBeanToCsv<Dish> dishBeanWriter(String dishFilePath,
                                                  ColumnPositionMappingStrategy<Dish> dishMappingStrategy) {
        FileWriter dishFileWriter;
        try {
            dishFileWriter = new FileWriter(dishFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new StatefulBeanToCsvBuilder<Dish>(dishFileWriter)
                .withMappingStrategy(dishMappingStrategy).build();
    }

    @Bean
    public ColumnPositionMappingStrategy<Linen> linenMappingStrategy() {
        ColumnPositionMappingStrategy<Linen> mappingStrategy =
                new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Linen.class);
        String[] columns = new String[]
                {"id", "price", "description",
                        "left_in_stock", "category", "material"};
        mappingStrategy.setColumnMapping(columns);
        return mappingStrategy;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StatefulBeanToCsv<Linen> linenBeanWriter(String linenFilePath,
                                                    ColumnPositionMappingStrategy<Linen> linenMappingStrategy) {
        FileWriter linenFileWriter;
        try {
            linenFileWriter = new FileWriter(linenFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new StatefulBeanToCsvBuilder<Linen>(linenFileWriter)
                .withMappingStrategy(linenMappingStrategy).build();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}