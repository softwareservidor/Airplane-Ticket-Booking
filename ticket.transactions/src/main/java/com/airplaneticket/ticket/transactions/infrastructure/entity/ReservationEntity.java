package com.airplaneticket.ticket.transactions.infrastructure.entity;
import com.airplaneticket.ticket.transactions.domain.model.Fligth;
import com.airplaneticket.ticket.transactions.domain.model.Ticket;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private UserEntity IduserEntity;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private FligthEntity fligthEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private TicketEntity ticket;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_reserva")
    private LocalDateTime reservationDate;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public UserEntity getIduserEntity() {
        return IduserEntity;
    }

    public void setIduserEntity(UserEntity iduserEntity) {
        IduserEntity = iduserEntity;
    }

    public FligthEntity getFligthEntity() {
        return fligthEntity;
    }

    public void setFligthEntity(FligthEntity fligthEntity) {
        this.fligthEntity = fligthEntity;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
