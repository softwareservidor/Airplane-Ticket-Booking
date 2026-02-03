package com.airplaneticket.ticket.transactions.application.usecase;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.domain.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.infrastructure.exception.InvalidDataException;
import reactor.core.publisher.Mono;

public class CreateReservationUseCase {
    private final ReservationRepository reservationRepository;

    public CreateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Mono<Reservation> excecute(Reservation reservation) {
        if(reservation.getUser().getUsername().length() > 30 || reservation.getUser().getUsername().matches("^[a-zA-Z0-9]*$")) {
            return Mono.error(new InvalidDataException("Username is too long, 30 caracters máx"));
        }
        return reservationRepository.save(reservation);
    }
}
