package com.example.featurescovoiturage.Controller;

 import com.example.featurescovoiturage.Entities.Offer;
 import com.example.featurescovoiturage.Services.OfferServices;
 import lombok.AllArgsConstructor;
 import lombok.NoArgsConstructor;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.websocket.server.PathParam;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
 import java.time.format.DateTimeFormatter;
 import java.util.Date;
 import java.util.List;
 import java.util.Optional;

@RestController
@RequestMapping("api/offers")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
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
    @GetMapping("offer/destination/{destination}")
    public Optional<List<Offer>> getOfferByDestinationn(@PathVariable String destination){
        System.out.println(destination);

        return Optional.ofNullable(offerServices.getOffersByDestination(destination));
    }
    @GetMapping("search")
    // get localhost:4500/api/offers/search?depart=rabat&arrival=taounat&date=16-02-2020
    public Optional<List<Offer>> searchOffer(@PathParam("depart") String depart, @PathParam("arrival") String arrival, @PathParam("date") String date){
        System.out.println(depart+" "+arrival+" "+date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date2=LocalDate.parse(date, dtf);
         System.out.println(date2.getYear()+" "+date2.getMonthValue());

        return Optional.ofNullable(offerServices.getOfferByDateAndDepartAndArrival(date2,depart,arrival));
    }


}
