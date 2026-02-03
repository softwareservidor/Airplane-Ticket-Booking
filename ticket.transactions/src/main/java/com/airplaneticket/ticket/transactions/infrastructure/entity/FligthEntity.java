package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class FligthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFligthEntiy;
    private String destinationCityEntity;
    private String descriptionEntity;
}
