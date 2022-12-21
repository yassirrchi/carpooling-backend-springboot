package com.example.featurescovoiturage.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*class offer{ville / adress / destination   date/ time depart / time arrive/ personne / comment / chaufeur / <list>passger /   prix  / confirmer / encours_deleted
    */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private Date startDate;
    private Date expectedArrival;
    @OneToMany
    private List<User> passengers;
    @OneToOne
    private User driver;
    private boolean confirmed;
    private Byte available_seats;
}
