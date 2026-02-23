package com.airplaneticket.ticket.transactions.application.usecase;

import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.domain.model.User;
import reactor.core.publisher.Mono;

public class FindUserUseCase {

    private final ReservationRepository reservationRepository;

    public FindUserUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Mono<User> findUserById(int id) {
        return reservationRepository.findUserById(id);
    }
}
