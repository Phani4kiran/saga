package com.example.saga.api;

import com.example.saga.service.CrimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class CrimeController {

    private final CrimeService crimeService;

    @GetMapping(path = "/crime/categories")
    public ResponseEntity<CrimeCategoriesResponse> getCrimeCategoriesList(){
       List<String>  categoriesList = crimeService.getCrimeCategoriesList();
        if(categoriesList.size() >0 ){
            CrimeCategoriesResponse crimeCategoriesResponse = CrimeCategoriesResponse.builder().categories(categoriesList).build();
            return    ResponseEntity.status(OK).body(crimeCategoriesResponse);
        }
        return ResponseEntity.status(NOT_FOUND).body(CrimeCategoriesResponse.builder().build());
    }

   @GetMapping(path="/crimes")
    public ResponseEntity<List<CrimesDetailsResponse>> getCrimesByPostCodeAndDate(@RequestParam String postcode,@RequestParam String date){
       List<CrimesDetailsResponse> crimesDetailsResponseList = crimeService.getCrimesByPostCodeAndDate(postcode)
        if(crimesDetailsResponseList.size()>0){
            return ResponseEntity.status(OK).body(crimesDetailsResponseList);

        }
       return ResponseEntity.status(NOT_FOUND).build());

   }

}
