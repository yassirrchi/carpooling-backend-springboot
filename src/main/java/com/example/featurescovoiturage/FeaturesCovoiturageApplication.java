package com.example.featurescovoiturage;

import com.example.featurescovoiturage.Entities.Offer;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Entities.Voiture;
import com.example.featurescovoiturage.Repositories.OfferRepository;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication

public class FeaturesCovoiturageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeaturesCovoiturageApplication.class, args);
    }
    @Bean
    CommandLineRunner initdb(UserRepository userRepository, OfferRepository offerRepository){
        //SELECT * FROM `offer` WHERE start_date>="2020-02-15"

        User user=new User();
        user.setEmail("yassir@rchi.ma");
        Voiture voiture=new Voiture();
        voiture.setBrand("toyoya");
        voiture.setCapacity((byte) 2);
        voiture.setModel("camry");
        user.setVoiture(voiture);


        user.setPassword("1234");
        userRepository.save(user);

        User user2=new User();
        user2.setEmail("zakaria@elk.ma");
        user2.setPassword("1234");
        userRepository.save(user2);






        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");




        Offer offer=new Offer();
        offer.setDepart("casa");
        offer.setArrival("taounat");
        offer.setAvailable_seats((byte) 4);
        offer.setStartDate(LocalDate.parse("13-02-2020", dtf));
        offerRepository.save(offer);
        Offer offer2=new Offer();
        offer2.setDepart("rabat");
        offer2.setArrival("taounat");
        offer2.setStartDate(LocalDate.parse("15-02-2020", dtf));


        offer2.setAvailable_seats((byte) 2);
        offerRepository.save(offer2);
        Offer offer4=new Offer();
        offer4.setDepart("rabat");
        offer4.setArrival("taounat");
        offer4.setStartDate(LocalDate.parse("26-02-2020", dtf));



        offer4.setAvailable_seats((byte) 2);
        offerRepository.save(offer4);
        Offer offer5=new Offer();
        offer5.setDepart("rabat");
        offer5.setStartDate(LocalDate.parse("27-02-2020", dtf));
        offer5.setArrival("taounat");



        offer5.setAvailable_seats((byte) 2);
        offerRepository.save(offer5);



        return null;
    };

}
