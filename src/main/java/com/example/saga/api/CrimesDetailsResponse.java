package com.example.saga.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrimesDetailsResponse {
    String category;
    Location location;
    String context;
    String outcome_status;
    String month;

}
