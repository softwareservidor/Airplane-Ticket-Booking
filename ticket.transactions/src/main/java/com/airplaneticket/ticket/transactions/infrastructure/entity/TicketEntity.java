package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicketEntity;
    private String ObservationEntity;
    @OneToMany(mappedBy = "ticket")
    private ReservationEntity reservation;
}
