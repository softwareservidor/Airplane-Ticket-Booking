package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    private int idUserEntity;
    private String usernameEntity;
    @OneToMany(mappedBy = "IduserEntity")
    private List<ReservationEntity> reservations;

    public int getIdUserEntity() {
        return idUserEntity;
    }

    public void setIdUserEntity(int idUserEntity) {
        this.idUserEntity = idUserEntity;
    }

    public String getUsernameEntity() {
        return usernameEntity;
    }

    public void setUsernameEntity(String usernameEntity) {
        this.usernameEntity = usernameEntity;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
