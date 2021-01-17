package com.example.jpaTest;

import javax.persistence.*;

@Entity
public class Car extends Vehicule {
    private int numberOfSeats;

    public Car(int numberOfSeats) {
        super();
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                '}';
    }
}
