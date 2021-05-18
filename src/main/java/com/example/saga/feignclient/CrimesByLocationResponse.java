package com.example.saga.feignclient;

import com.example.saga.api.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrimesByLocationResponse {
    String category;
    Location location;
    OutComeStatus outcome_status;
    String month;

}
