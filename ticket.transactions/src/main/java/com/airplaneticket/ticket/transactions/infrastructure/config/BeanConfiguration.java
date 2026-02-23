package com.airplaneticket.ticket.transactions.infrastructure.config;

import com.airplaneticket.ticket.transactions.application.usecase.CreateReservationUseCase;
import com.airplaneticket.ticket.transactions.application.usecase.FindReservationUseCase;
import com.airplaneticket.ticket.transactions.application.port.ReservationRepository;
import com.airplaneticket.ticket.transactions.application.usecase.FindUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationRepository reservationRepository) {
        return new CreateReservationUseCase(reservationRepository);
    }

    @Bean
    public FindReservationUseCase findReservationUseCase(ReservationRepository reservationRepository) {
        return new FindReservationUseCase(reservationRepository);
    }

    @Bean
    public FindUserUseCase findUserUseCase(ReservationRepository reservationRepository) {
        return new FindUserUseCase(reservationRepository);
    }
}
