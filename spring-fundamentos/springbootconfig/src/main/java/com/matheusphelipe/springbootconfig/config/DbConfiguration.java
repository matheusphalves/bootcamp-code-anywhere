package com.matheusphelipe.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DbConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDataBaseConnection(){
        System.out.println("DB connection for DEV - MYSQL");
        System.out.println(this.driverClassName);
        System.out.println(this.url);
        return "DB connection to MYSQL_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String testDataBaseConnectionProd(){
        System.out.println("DB connection for PRODUCTION - MYSQL");
        System.out.println(this.driverClassName);
        System.out.println(this.url);
        return "DB connection to MYSQL_PROD - Production instance";
    }
}
