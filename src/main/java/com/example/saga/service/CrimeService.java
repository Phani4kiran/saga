package com.example.saga.service;

import com.example.saga.api.CrimesDetailsResponse;
import com.example.saga.api.Location;
import com.example.saga.feignclient.PoliceCrimeCategories;
import com.example.saga.feignclient.PoliceFeignClient;
import com.example.saga.feignclient.PostCodesFeignClient;
import com.example.saga.feignclient.PostCodesFeignResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CrimeService {

    private final PoliceFeignClient policeFeignClient;
    private final PostCodesFeignClient postCodesFeignClient;

    public List<String> getCrimeCategoriesList() {
        return policeFeignClient.getPoliceCrimeCategoriesList("").stream()
                .map(PoliceCrimeCategories::getName).collect(Collectors.toList());

    }

    public List<CrimesDetailsResponse> getCrimesByPostCodeAndDate(String postCode, String date) {
        final PostCodesFeignResponse locationByPostcodes = postCodesFeignClient.getLocationByPostCode(postCode);//
        // if status  is ok then take result and build CrimesDetailsResponse .
        final Location result = locationByPostcodes.getResult();

        System.out.println("HareKrishna "+locationByPostcodes.getStatus());
        return null;

    }
}
