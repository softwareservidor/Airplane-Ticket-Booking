package com.airplaneticket.ticket.transactions.infrastructure;

import com.airplaneticket.ticket.transactions.application.dto.ReservationRequestDTO;
import com.airplaneticket.ticket.transactions.application.usecase.FindReservationUseCase;
import com.airplaneticket.ticket.transactions.application.usecase.FindUserUseCase;
import com.airplaneticket.ticket.transactions.domain.model.Fligth;
import com.airplaneticket.ticket.transactions.domain.model.Reservation;
import com.airplaneticket.ticket.transactions.domain.model.Ticket;
import com.airplaneticket.ticket.transactions.domain.model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.airplaneticket.ticket.transactions.infrastructure.message.ReservationMessages;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.airplaneticket.ticket.transactions.application.usecase.CreateReservationUseCase;

@RestController
@RequestMapping("/airline")
public class ReservationController {
    private final CreateReservationUseCase createReservationUseCase;
    private final FindReservationUseCase findReservationUseCase;
    private final FindUserUseCase findUserUseCase;

    public ReservationController(CreateReservationUseCase createReservationUseCase, FindReservationUseCase findReservationUseCase, FindUserUseCase findUserUseCase) {
        this.createReservationUseCase = createReservationUseCase;
        this.findReservationUseCase = findReservationUseCase;
        this.findUserUseCase = findUserUseCase;
    }


    @PostMapping("/reservar")
    public Mono<ResponseEntity<ApiResponse<Reservation>>> create(@Valid @RequestBody final ReservationRequestDTO dto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Reservation reservation = new Reservation(
            dto.getIdReservation(),
            LocalDateTime.parse(dto.getReservationDate(), formatter),
            new User(dto.getUser().getIdUser(), dto.getUser().getUsername()),
            new Fligth(dto.getFligth().getIdFligth(), dto.getFligth().getDestinationCity(),""),
            new Ticket(dto.getTicket().getIdTicket(), dto.getTicket().getObservation())
        );
        return findUserUseCase.findUserById(reservation.getUser().getIdUser())
                .flatMap(existingUser -> Mono.just(ResponseEntity.badRequest()
                        .body(new ApiResponse<Reservation>(null, 409, ReservationMessages.USER_ALREADY_HAS_RESERVATION))))
                .switchIfEmpty(
                        createReservationUseCase.createReservation(reservation)
                                .map(saved -> ResponseEntity.ok(new ApiResponse<>(saved, 201, ReservationMessages.RESERVATION_CREATED)))
                )
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest()
                        .body(new ApiResponse<Reservation>(null, 400, e.getMessage()))));

    }

    @GetMapping("/getById/{id}")
    public Mono<ResponseEntity<ApiResponse<Reservation>>> getReservation(@PathVariable int id) {
        return findReservationUseCase.findById(id)
                .map(reservation -> ResponseEntity.ok(new ApiResponse<>(reservation, 200, ReservationMessages.RESERVATION_FOUND)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
