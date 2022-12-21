package com.example.featurescovoiturage.Repositories;

import com.example.featurescovoiturage.Entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

}
