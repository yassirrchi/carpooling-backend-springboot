package com.example.featurescovoiturage.DTO;

import com.example.featurescovoiturage.Enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataAndDoc {
    private Long userId;
    private DocumentType documentType;

}
