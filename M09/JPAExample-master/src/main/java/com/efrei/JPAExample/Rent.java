package com.efrei.JPAExample;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {
    private Date beginRent;
    private Date endRent;

    public Rent(Date beginRent, Date endRent) {
        this.beginRent = beginRent;
        this.endRent = endRent;
    }

    @Id
    public Date getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Date beginRent) {
        this.beginRent = beginRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }
}
