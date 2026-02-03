package com.airplaneticket.ticket.transactions.infrastructure.config;

import com.airplaneticket.ticket.transactions.application.usecase.CreateReservationUseCase;
import com.airplaneticket.ticket.transactions.domain.port.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationRepository reservationRepository) {
        return new CreateReservationUseCase(reservationRepository);
    }
}
