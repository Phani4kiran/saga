package com.example.saga.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "Postcode-Feign-Client",
        url = "https://data.police.uk/api"
)
public interface PostCodesFeignClient {

   @GetMapping(value = "/postcodes", produces = MediaType.APPLICATION_JSON_VALUE)
   PostCodesFeignResponse getLocationByPostcodes(@RequestParam("q") String postcode);


}
