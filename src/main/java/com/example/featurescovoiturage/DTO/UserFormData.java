package com.example.featurescovoiturage.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormData {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String cni;


}
