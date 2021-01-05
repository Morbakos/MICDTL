package com.efrei.JPAExample;

import javax.persistence.*;

@Entity
public class Van extends Vehicle{
    private float maxWeight;

    public Van(String plateNumber, float maxWeight) {
        super(plateNumber);
        this.maxWeight = maxWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }
}
