package com.airplaneticket.ticket.transactions.application.usecase;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import reactor.core.publisher.Mono;

public class FindReservationUseCase {

    private final ReservationRepository reservationRepository;

    public FindReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Mono<Reservation> findById(int id) {
        return reservationRepository.findById(id);
    }
}
