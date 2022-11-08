package com.example.featurescovoiturage.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String pw;
    private String lastName;
    private boolean personalIdConfirmed;
    private boolean carRegConfirmed;

    @Lob
    @Nullable
    @Column(length = 20971520)
    private byte[] personalIdCard;
    @Lob
    @Nullable
    @Column(length = 20971520)
    private byte[] carReg;
}
