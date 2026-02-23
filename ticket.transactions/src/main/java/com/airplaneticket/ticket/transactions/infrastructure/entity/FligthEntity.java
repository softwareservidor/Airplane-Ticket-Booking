package com.airplaneticket.ticket.transactions.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelos")
public class FligthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFligthEntiy;
    private String destinationCityEntity;
    @OneToOne(mappedBy = "fligthEntity")
    private ReservationEntity reservationEntity;

    public int getIdFligthEntiy() {
        return idFligthEntiy;
    }

    public void setIdFligthEntiy(int idFligthEntiy) {
        this.idFligthEntiy = idFligthEntiy;
    }

    public String getDestinationCityEntity() {
        return destinationCityEntity;
    }

    public void setDestinationCityEntity(String destinationCityEntity) {
        this.destinationCityEntity = destinationCityEntity;
    }

    public ReservationEntity getReservationEntity() {
        return reservationEntity;
    }

    public void setReservationEntity(ReservationEntity reservationEntity) {
        this.reservationEntity = reservationEntity;
    }
}
