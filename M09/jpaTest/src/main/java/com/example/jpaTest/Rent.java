package com.example.jpaTest;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {
    private Date beginRent;
    private Date entRent;
    private long id;
    private Person driver;

    public Rent() {
        super();
    }

    public Rent(Date beginRent, Date entRent) {
        this.beginRent = beginRent;
        this.entRent = entRent;
    }

    public Date getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Date beginRent) {
        this.beginRent = beginRent;
    }

    public Date getEntRent() {
        return entRent;
    }

    public void setEntRent(Date entRent) {
        this.entRent = entRent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "beginRent=" + beginRent +
                ", entRent=" + entRent +
                ", id=" + id +
                ", driver=" + driver +
                '}';
    }
}
