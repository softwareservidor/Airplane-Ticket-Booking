package com.airplaneticket.ticket.transactions.infrastructure.entity;
import com.airplaneticket.ticket.transactions.domain.model.Fligth;
import com.airplaneticket.ticket.transactions.domain.model.Ticket;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private int userEntity;
    private int fligthEntity;
    private int ticket;

    @Column(name = "fecha_reserva")
    private LocalDateTime reservationDate;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(int userEntity) {
        this.userEntity = userEntity;
    }

    public int getFligthEntity() {
        return fligthEntity;
    }

    public void setFligthEntity(int fligthEntity) {
        this.fligthEntity = fligthEntity;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
