package com.practice.exercise.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Profile("test")
@Configuration
//@EnableJpaRepositories(basePackages = {
//        "com.practice.exercise.infrastructure.repository.device",
//        "com.practice.exercise.infrastructure.configuration.auth.repository"
//})
@PropertySource("classpath:./application-test.yml")
public class H2Datasource {

    @Bean
    @ConfigurationProperties("h2.spring.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

}

