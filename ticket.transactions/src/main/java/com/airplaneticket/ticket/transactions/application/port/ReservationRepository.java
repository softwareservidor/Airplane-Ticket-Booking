package com.airplaneticket.ticket.transactions.application.port;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.domain.model.User;
import reactor.core.publisher.Mono;

public interface ReservationRepository {
    Mono<Reservation> save(Reservation reservation);
    Mono<Reservation> findById(int id);
    Mono<User> findUserById(int id);
}
