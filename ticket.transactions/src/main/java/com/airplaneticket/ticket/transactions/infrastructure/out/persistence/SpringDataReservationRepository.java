package com.airplaneticket.ticket.transactions.infrastructure.out.persistence;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservationRepository extends JpaRepository<Reservation, Long> {
}
