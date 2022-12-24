package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.Entities.Offer;
import com.example.featurescovoiturage.Repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferServicesImpl implements OfferServices {
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }



    public Optional<Offer> getOffer(Long id) {
        return offerRepository.findById(id);
    }


    @Override
    public boolean AddOffer(Offer offer) {
        offer.setConfirmed(false);
        offerRepository.save(offer);
        return true;
    }

    @Override
    public List<Offer> getOffersByDestination(String destination) {
        return offerRepository.findByDestination(destination);
    }

    @Override
    public List<Offer> getOfferByDateAndDepartAndArrival(LocalDate localDate, String depart, String arrival) {
        return offerRepository.findByStartDateGreaterThanEqualAndAndDepartEqualsAndAndArrivalEquals(localDate,depart,arrival);
    }
}
