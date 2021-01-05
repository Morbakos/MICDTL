package com.efrei.JPAExample;

import javax.persistence.*;

@Entity
public class Car extends Vehicle{

    private int numberOfSeats;

    public Car(String plateNumber, int numberOfSeats) {
        super(plateNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
