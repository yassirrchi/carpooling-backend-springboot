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
    private String CIN;
    private byte verificationStep;
    private boolean isEmailVerified;
    private String phoneNumber;
    private boolean isPhoneNumberVerified;
    private String password;
    private String lastName;
    @OneToOne
    private Voiture voiture;
    private boolean personalIdConfirmed;//to be replaced by verifStep service/controller layer
    private boolean carRegConfirmed;//to be replaced by verifStep service/controller layer
    @Lob
    @Nullable
    @Column(length = 20971520)
    private byte[] personalIdCard;
    @Lob
    @Nullable
    @Column(length = 20971520)
    private byte[] carReg;
    @Lob
    @Nullable
    @Column(length = 20971520)
    private byte[] profilePic;
}
