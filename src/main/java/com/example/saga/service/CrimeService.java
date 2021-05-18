package com.example.saga.service;

import com.example.saga.api.CrimesDetailsResponse;
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

    public List<CrimesDetailsResponse> getCrimesByPostCodeAndDate(String postCode) {
        final PostCodesFeignResponse locationByPostcodes = postCodesFeignClient.getLocationByPostcodes(postCode);
        System.out.println("HareKrishna "+locationByPostcodes.getStatus());
        return null;

    }
}
