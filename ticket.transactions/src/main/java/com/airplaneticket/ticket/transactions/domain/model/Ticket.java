package com.airplaneticket.ticket.transactions.domain.model;

public class Ticket {
    private int idTicket;
    private String observation;


    public Ticket(int idTicket, String observation) {
        this.idTicket = idTicket;
        this.observation = observation;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
