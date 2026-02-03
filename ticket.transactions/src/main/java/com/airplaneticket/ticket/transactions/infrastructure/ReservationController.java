package com.airplaneticket.ticket.transactions.infrastructure;

import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.airplaneticket.ticket.transactions.application.usecase.CreateReservationUseCase;

@RestController
@RequestMapping("/airline")
public class ReservationController {
    private final CreateReservationUseCase createReservationUseCase;

    public ReservationController(CreateReservationUseCase createReservationUseCase) {
        this.createReservationUseCase = createReservationUseCase;
    }


    @PostMapping("/reservar")
    public Mono<ResponseEntity<ApiResponse<Reservation>>> create(@RequestBody final Reservation reservation) {
        return createReservationUseCase.excecute(reservation)
                .map(saved -> ResponseEntity.ok(new ApiResponse<>(saved, 200, "Reserva creada exitosamente")))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest()
                        .body(new ApiResponse<>(null, 400, e.getMessage()))));
    }
}
