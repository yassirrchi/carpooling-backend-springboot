package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServicesImpl implements userServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
