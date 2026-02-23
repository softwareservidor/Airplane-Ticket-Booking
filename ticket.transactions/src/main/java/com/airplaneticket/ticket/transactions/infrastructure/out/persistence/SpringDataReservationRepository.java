package com.airplaneticket.ticket.transactions.infrastructure.out.persistence;

import com.airplaneticket.ticket.transactions.infrastructure.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
