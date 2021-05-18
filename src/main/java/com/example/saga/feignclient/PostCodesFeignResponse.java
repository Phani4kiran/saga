package com.example.saga.feignclient;

import com.example.saga.api.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCodesFeignResponse {
    String status;
    Location result;
}
