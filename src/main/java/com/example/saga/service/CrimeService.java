package com.example.saga.service;

import com.example.saga.api.CrimesDetailsResponse;
import com.example.saga.api.Location;
import com.example.saga.feignclient.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        final PostCodesFeignResponse postCodesFeignResponse = postCodesFeignClient.getLocationByPostCode(postCode);//
        // if status  is ok then take result and build CrimesDetailsResponse .
        if(postCodesFeignResponse.getStatus()==200){
            final Location location = postCodesFeignResponse.getResult();
            // polic api with location
            final List<CrimesByLocationResponse> crimesAtLocation = policeFeignClient.getCrimesAtLocation(location.getLongitude(), location.getLatitude(), date);
            // transform to CrimesDetailsResponse.
           // crimesAtLocation.stream().
           //         map(e->CrimesDetailsResponse.builder().location() )
            return null; //CrimesDetailsResponse.builder().location(location).build();
        }
        System.out.println("HareKrishna ");
        return null;

    }
}
