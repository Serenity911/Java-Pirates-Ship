package com.codeclan.example.pirateservice_d1_starter.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ship_id;

    @Column
    private String shipName;

//    todo WHY WHY WHY DOES IT HAVE TO BE A LIST AND NOT AN ARRAYLIST.
//    why!
    @OneToMany(mappedBy = "ship")
    private List<Pirate> pirates = new ArrayList<>();

    public Ship(String shipName) {
        this.shipName = shipName;

    }

    public Ship() {
    }

    public Long getId() {
        return ship_id;
    }

    public void setId(Long id) {
        this.ship_id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

}
