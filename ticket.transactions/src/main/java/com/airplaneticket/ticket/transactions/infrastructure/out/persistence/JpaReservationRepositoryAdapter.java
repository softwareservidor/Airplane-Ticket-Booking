package com.airplaneticket.ticket.transactions.infrastructure.out.persistence;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.domain.model.User;
import com.airplaneticket.ticket.transactions.infrastructure.entity.ReservationEntity;
import com.airplaneticket.ticket.transactions.infrastructure.entity.FligthEntity;
import com.airplaneticket.ticket.transactions.infrastructure.entity.TicketEntity;
import com.airplaneticket.ticket.transactions.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@Component("reservationRepositoryAdapter")
public class JpaReservationRepositoryAdapter  implements ReservationRepository {

    private final SpringDataReservationRepository jpaRepository;

    public JpaReservationRepositoryAdapter(SpringDataReservationRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Mono<Reservation> save(Reservation reservation) {

        return Mono.fromCallable(() -> {
            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.setIdReservation(reservation.getIdReservation());
            reservationEntity.setReservationDate(reservation.getReservationDate());

            UserEntity userEntity = new UserEntity();
            userEntity.setIdUserEntity(reservation.getUser().getIdUser());
            userEntity.setUsernameEntity(reservation.getUser().getUsername());
            reservationEntity.setIduserEntity(userEntity);

            FligthEntity fligthEntity = new FligthEntity();
            fligthEntity.setIdFligthEntiy(reservation.getFligth().getIdFligth());
            fligthEntity.setDestinationCityEntity(reservation.getFligth().getDestinationCity());
            reservationEntity.setFligthEntity(fligthEntity);

            TicketEntity ticketEntity = new TicketEntity();
            ticketEntity.setIdTicketEntity(reservation.getTicket().getIdTicket());
            ticketEntity.setObservationEntity(reservation.getTicket().getObservation());
            reservationEntity.setTicket(ticketEntity);

            return jpaRepository.save(reservationEntity);
        }).map(savedEntity -> {
             return reservation;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Reservation> findById(int id) {
        return Mono.fromCallable(() -> jpaRepository.findById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap((Optional<ReservationEntity> optionalEntity) -> {
                    if (optionalEntity.isPresent()) {
                        ReservationEntity reservationEntity = optionalEntity.get();

                        Reservation reservation = new Reservation();
                        reservation.setIdReservation(reservationEntity.getIdReservation());
                        reservation.setReservationDate(reservationEntity.getReservationDate());
                        reservation.setUser(new com.airplaneticket.ticket.transactions.domain.model.User(
                            reservationEntity.getIduserEntity().getIdUserEntity(),
                            reservationEntity.getIduserEntity().getUsernameEntity()
                        ));
                        reservation.setFligth(new com.airplaneticket.ticket.transactions.domain.model.Fligth(
                            reservationEntity.getFligthEntity().getIdFligthEntiy(),
                            reservationEntity.getFligthEntity().getDestinationCityEntity(),
                            ""
                        ));
                        reservation.setTicket(new com.airplaneticket.ticket.transactions.domain.model.Ticket(
                            reservationEntity.getTicket().getIdTicketEntity(),
                            reservationEntity.getTicket().getObservationEntity()
                        ));
                        return Mono.just(reservation);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<User> findUserById(int id) {
        return Mono.fromCallable(() -> jpaRepository.findById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap((Optional<ReservationEntity> optionalEntity) -> {
                    if (optionalEntity.isPresent()) {
                        ReservationEntity reservationEntity = optionalEntity.get();
                        User user = new User();
                        user.setIdUser(reservationEntity.getIduserEntity().getIdUserEntity());
                        user.setUsername(reservationEntity.getIduserEntity().getUsernameEntity());
                        return Mono.just(user);
                    }
                    return Mono.empty();
                });
    }
}
