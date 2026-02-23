package com.airplaneticket.ticket.transactions.application.useCase;

import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.application.usecase.CreateReservationUseCase;
import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class CreateReservationUseCaseTest {
    private ReservationRepository reservationRepository;
    private CreateReservationUseCase createReservationUseCase;

    @BeforeEach
    void setup() {
        reservationRepository = mock(ReservationRepository.class);
        createReservationUseCase = new CreateReservationUseCase(reservationRepository);
    }

    @Test
    void shouldSaveAndReturnAReservation() {
        Reservation reservation = new Reservation();
        when(reservationRepository.save(reservation)).thenReturn(Mono.just(reservation));

        Mono<Reservation> result = createReservationUseCase.createReservation(reservation);
        StepVerifier.create(result)
                .expectNext(reservation)
                .verifyComplete();

        verify(reservationRepository, times(1)).save(reservation);
    }
    @Test
    void shouldPropagateErrorWhenRepositoryFails() {
        Reservation reservation = new Reservation();
        RuntimeException error = new RuntimeException("DB error");
        when(reservationRepository.save(reservation)).thenReturn(Mono.error(error));

        Mono<Reservation> result = createReservationUseCase.createReservation(reservation);

        StepVerifier.create(result)
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException
                        && throwable.getMessage().equals("DB error"))
                .verify();

        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void shouldCallRepositoryWithGivenReservation() {
        Reservation reservation = new Reservation();
        when(reservationRepository.save(any(Reservation.class))).thenReturn(Mono.just(reservation));

        createReservationUseCase.createReservation(reservation).block();

        verify(reservationRepository).save(reservation);
    }
}

