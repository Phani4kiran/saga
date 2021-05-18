package com.example.saga.feignclient;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PoliceFeignConfiguration {

    @Bean
    public Logger logger() {
        return new Slf4jLogger();
    }

    @Bean
    public Logger.Level level() {
        return Logger.Level.BASIC;
    }

}
