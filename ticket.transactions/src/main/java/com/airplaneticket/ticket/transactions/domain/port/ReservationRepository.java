package com.airplaneticket.ticket.transactions.domain.port;

import com.airplaneticket.ticket.transactions.domain.model.Fligth;
import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface ReservationRepository {
    Mono<Reservation> save(Reservation reservation);
    Optional<Reservation> findById(Long id);
}
