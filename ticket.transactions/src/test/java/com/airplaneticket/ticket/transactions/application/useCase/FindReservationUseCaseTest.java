package com.airplaneticket.ticket.transactions.application.useCase;

import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.application.usecase.FindReservationUseCase;
import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class FindReservationUseCaseTest {
    private ReservationRepository reservationRepository;
    private FindReservationUseCase findReservationUseCase;

    @BeforeEach
    void setup() {
        reservationRepository = mock(ReservationRepository.class);
        findReservationUseCase = new FindReservationUseCase(reservationRepository);
    }

    @Test
    void shouldReturnReservationWhenFound() {
        int id = 1;
        Reservation reservation = new Reservation();
        when(reservationRepository.findById(id)).thenReturn(Mono.just(reservation));

        Mono<Reservation> result = findReservationUseCase.findById(id);

        StepVerifier.create(result)
                .expectNext(reservation)
                .verifyComplete();

        verify(reservationRepository, times(1)).findById(id);
    }

    @Test
    void shouldPropagateErrorWhenRepositoryFails() {
        int id = 2;
        RuntimeException error = new RuntimeException("DB error");
        when(reservationRepository.findById(id)).thenReturn(Mono.error(error));

        Mono<Reservation> result = findReservationUseCase.findById(id);

        StepVerifier.create(result)
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException
                        && throwable.getMessage().equals("DB error"))
                .verify();

        verify(reservationRepository, times(1)).findById(id);
    }

    @Test
    void shouldCallRepositoryWithGivenId() {
        int id = 3;
        Reservation reservation = new Reservation();
        when(reservationRepository.findById(anyInt())).thenReturn(Mono.just(reservation));

        findReservationUseCase.findById(id).block();

        verify(reservationRepository).findById(id);
    }
}
