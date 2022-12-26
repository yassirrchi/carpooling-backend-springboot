package com.example.featurescovoiturage.Controller;

import com.example.featurescovoiturage.DTO.UserFormData;
import com.example.featurescovoiturage.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.featurescovoiturage.Services.accountServices;
import org.springframework.http.ResponseEntity.*;

//temp // spring security
@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class userAuth {
    @Autowired
    private accountServices accountServicesO;
    @PostMapping("user/login")
    public ResponseEntity<?> login(@RequestBody UserFormData user){
        User userToExist= accountServicesO.findUserByEmail(user);
        if(userToExist!=null)
            return ResponseEntity.ok(userToExist);
        return ResponseEntity.status(401).build();

    }
    @PostMapping("user/signup")
    public ResponseEntity<?> signup(@RequestBody UserFormData user){
        if(accountServicesO.saveUser(user))
        {User userToExist= accountServicesO.findUserByEmail(user);
         return ResponseEntity.ok(userToExist);
        }
        else return ResponseEntity.status(401).build();

    }


}
