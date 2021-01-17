package com.example.jpaTest;

import javax.persistence.*;

@Entity
public class Vehicule {
    private String plateNumber;
    private long id;

    public Vehicule() {
        super();
    }

    public Vehicule(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "plateNumber='" + plateNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
