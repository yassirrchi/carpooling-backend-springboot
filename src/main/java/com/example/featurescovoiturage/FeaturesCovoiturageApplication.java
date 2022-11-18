package com.example.featurescovoiturage;

import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

public class FeaturesCovoiturageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeaturesCovoiturageApplication.class, args);
    }
    @Bean
    CommandLineRunner initdb(UserRepository userRepository){
        User user=new User();
        user.setEmail("yassir@rchi.ma");

        user.setPassword("1234");
        userRepository.save(user);
        return null;
    };

}
