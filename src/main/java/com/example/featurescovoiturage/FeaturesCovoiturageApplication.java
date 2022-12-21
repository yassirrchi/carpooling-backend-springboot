package com.example.featurescovoiturage;

import com.example.featurescovoiturage.Entities.Offer;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Repositories.OfferRepository;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@SpringBootApplication

public class FeaturesCovoiturageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeaturesCovoiturageApplication.class, args);
    }
    @Bean
    CommandLineRunner initdb(UserRepository userRepository, OfferRepository offerRepository){

        User user=new User();
        user.setEmail("yassir@rchi.ma");

        user.setPassword("1234");
        userRepository.save(user);

        Offer offer=new Offer();
        offer.setDestination("casa");
        offer.setAvailable_seats((byte) 4);
        offerRepository.save(offer);
        Offer offer2=new Offer();
        offer2.setDestination("rabat");
        offer2.setStartDate(new Date());
        offer2.setAvailable_seats((byte) 2);
        offerRepository.save(offer2);



        return null;
    };

}
