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

    public static class UserDTO {

        private int idUser;
        @Size(max = 30, message = "Username es muy extenso, 30 caracteres máximo")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username solo puede contener letras y números")
        private String username;
        public int getIdUser() { return idUser; }
        public void setIdUser(int idUser) { this.idUser = idUser; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
    }
    public static class FligthDTO {
        private int idFligth;
        private String destinationCity;
        public int getIdFligth() { return idFligth; }
        public void setIdFligth(int idFligth) { this.idFligth = idFligth; }
        public String getDestinationCity() { return destinationCity; }
        public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    }
    public static class TicketDTO {
        private int idTicket;
        private String observation;
        public int getIdTicket() { return idTicket; }
        public void setIdTicket(int idTicket) { this.idTicket = idTicket; }
        public String getObservation() { return observation; }
        public void setObservation(String observation) { this.observation = observation; }
    }
}
