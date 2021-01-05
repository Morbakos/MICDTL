package com.example.CarRental;

public class Dates {
    private String dateDebut;
    private String dateFin;

    public Dates () { super(); }

    public Dates (String dateDebut, String dateFin) {
        super();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateFin() {
        return dateFin;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                '}';
    }
}
