package com.airplaneticket.ticket.transactions.domain.model;

public class Fligth {

    private int idFligth;
    private String destinationCity;
    private String description;

    public Fligth(int idFligth, String destinationCity, String description) {
        this.idFligth = idFligth;
        this.destinationCity = destinationCity;
        this.description = description;
    }

    public int getIdFligth() {
        return idFligth;
    }

    public void setIdFligth(int idFligth) {
        this.idFligth = idFligth;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
