package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tiketes")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicketEntity;
    private String observationEntity;
    @OneToOne(mappedBy = "ticket")
    private ReservationEntity reservation;

    public int getIdTicketEntity() {
        return idTicketEntity;
    }

    public void setIdTicketEntity(int idTicketEntity) {
        this.idTicketEntity = idTicketEntity;
    }

    public String getObservationEntity() {
        return observationEntity;
    }

    public void setObservationEntity(String observationEntity) {
        this.observationEntity = observationEntity;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }
}
