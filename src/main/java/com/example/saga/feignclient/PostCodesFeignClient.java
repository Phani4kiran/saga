package com.example.saga.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@FeignClient(
        value = "Postcode-Feign-Client",
        url = "https://api.postcodes.io"
)
public interface PostCodesFeignClient {

   @GetMapping(value = "/postcodes/{postcode}", produces = MediaType.APPLICATION_JSON_VALUE)
   PostCodesFeignResponse getLocationByPostCode(@PathVariable String postcode);


}

