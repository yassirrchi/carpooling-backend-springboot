package com.example.featurescovoiturage.Controller;

import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Repositories.UserRepository;
import com.example.featurescovoiturage.Services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users/")
public class UsersController {
    @Autowired
    private userServices userServices;

    @GetMapping("all")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }


}
