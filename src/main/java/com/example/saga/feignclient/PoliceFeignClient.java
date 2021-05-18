package com.example.saga.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value = "Police-Feign-Client",
        url = "https://data.police.uk/api",
        configuration = {PoliceFeignConfiguration.class}
)
public interface PoliceFeignClient {

    @GetMapping(value = "/crime-categories", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PoliceCrimeCategories> getPoliceCrimeCategoriesList(@RequestParam(required = false, name="date") String date);

}
