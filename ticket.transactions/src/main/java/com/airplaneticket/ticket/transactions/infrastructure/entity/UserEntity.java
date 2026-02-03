package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserEntity;
    private String usernameEntity;
    @OneToMany(mappedBy = "user")
    private List<ReservationEntity> reservations;
}
