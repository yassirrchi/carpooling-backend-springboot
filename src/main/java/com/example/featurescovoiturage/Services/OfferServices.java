package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.Entities.Offer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OfferServices {
    public List<Offer> getAllOffers();
    public Optional<Offer> getOffer(Long id);
    public boolean AddOffer(Offer offer);
    public List<Offer> getOffersByDestination(String destination);
    public List<Offer> getOfferByDateAndDepartAndArrival(LocalDate localDate,String depart,String arrival);


}
