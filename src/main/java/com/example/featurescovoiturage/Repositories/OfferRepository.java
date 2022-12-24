package com.example.featurescovoiturage.Repositories;

import com.example.featurescovoiturage.Entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    List<Offer> findByDestination(String destination);
    List<Offer> findByArrival(String arrival);

    List<Offer> findByStartDateGreaterThanEqualAndAndDepartEqualsAndAndArrivalEquals(LocalDate localDate,String depart,String arrival);





}
