package com.airplaneticket.ticket.transactions.application.dto;

public class TicketDTO {
    private int idTicket;
    private String observation;
    public int getIdTicket() { return idTicket; }
    public void setIdTicket(int idTicket) { this.idTicket = idTicket; }
    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }
}
