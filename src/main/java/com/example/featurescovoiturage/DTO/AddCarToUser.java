package com.example.featurescovoiturage.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCarToUser {
    private Long userid;
    private String brand;
    private String model;
    private byte capacity;
}
