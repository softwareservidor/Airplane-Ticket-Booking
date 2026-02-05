package com.airplaneticket.ticket.transactions.infrastructure.out.persistence;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.domain.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.infrastructure.entity.ReservationEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component("reservationRepositoryAdapter")
public class JpaReservationRepositoryAdapter  implements ReservationRepository {

    private final SpringDataReservationRepository jpaRepository;

    public JpaReservationRepositoryAdapter(SpringDataReservationRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Mono<Reservation> save(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setIdReservation(reservation.getIdReservation());
        entity.setUserEntity(reservation.getUser().getIdUser());
        return Mono.just(reservation);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return Optional.empty();
    }
}
