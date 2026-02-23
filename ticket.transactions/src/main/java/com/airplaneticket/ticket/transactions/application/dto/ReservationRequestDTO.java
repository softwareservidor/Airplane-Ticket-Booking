package com.airplaneticket.ticket.transactions.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReservationRequestDTO {
    private int idReservation;
    private String reservationDate;
    @Valid
    private UserDTO user;
    private FligthDTO fligth;
    private TicketDTO ticket;

    public int getIdReservation() { return idReservation; }
    public void setIdReservation(int idReservation) { this.idReservation = idReservation; }
    public String getReservationDate() { return reservationDate; }
    public void setReservationDate(String reservationDate) { this.reservationDate = reservationDate; }
    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }
    public FligthDTO getFligth() { return fligth; }
    public void setFligth(FligthDTO fligth) { this.fligth = fligth; }
    public TicketDTO getTicket() { return ticket; }
    public void setTicket(TicketDTO ticket) { this.ticket = ticket; }

}
