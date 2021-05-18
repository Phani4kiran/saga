package com.example.saga.config;

import com.example.saga.feignclient.PoliceFeignClient;
import com.example.saga.feignclient.PostCodesFeignClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {PoliceFeignClient.class,
        PostCodesFeignClient.class})
public class SagaConfiguration {
}
