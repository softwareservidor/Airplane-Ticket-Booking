package com.airplaneticket.ticket.transactions.domain.model;

public class Ticket {
    private int idTicket;
    private String Observation;


    public Ticket(int idTicket, String observation) {
        this.idTicket = idTicket;
        Observation = observation;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }
}
