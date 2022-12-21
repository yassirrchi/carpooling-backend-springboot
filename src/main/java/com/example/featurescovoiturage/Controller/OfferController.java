package com.example.featurescovoiturage.Controller;

 import com.example.featurescovoiturage.Entities.Offer;
 import com.example.featurescovoiturage.Services.OfferServices;
 import lombok.AllArgsConstructor;
 import lombok.NoArgsConstructor;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
 import java.util.Optional;

@RestController
@RequestMapping("api/offers")
@AllArgsConstructor
@NoArgsConstructor
public class OfferController {
    @Autowired
    private OfferServices offerServices;

//postman test  http://localhost:4500/api/offers/create
    /* body
     {
     "destination":"casablanac",
     "available_seats":6
 }

     */


    @PostMapping("create")
    public int createOffer(@RequestBody Offer offer){
        offerServices.AddOffer(offer);

        return 3;
    }


    // postman test  http://localhost:4500/api/offers/all
    @GetMapping("all")
    public List<Offer> getAllOffers(){

        return offerServices.getAllOffers();
    }
    // postman test  http://localhost:4500/api/offers/offer/1
    @GetMapping("offer/{id}")
    public Optional<Offer> getOffer(@PathVariable Long id){
        System.out.println(id);
        return offerServices.getOffer(id);
    }

}
