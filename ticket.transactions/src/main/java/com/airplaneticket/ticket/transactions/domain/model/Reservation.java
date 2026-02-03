package com.airplaneticket.ticket.transactions.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Reservation {
    private int idReservation;
    private LocalDateTime reservationDate;
    private User user;
    private Fligth fligth;
    private Ticket ticket;

    public Reservation(int idReservation, LocalDateTime reservationDate, User user, Fligth fligth, Ticket ticket) {
        this.idReservation = idReservation;
        this.reservationDate = reservationDate;
        this.user = user;
        this.fligth = fligth;
        this.ticket = ticket;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Fligth getFligth() {
        return fligth;
    }

    public void setFligth(Fligth fligth) {
        this.fligth = fligth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
