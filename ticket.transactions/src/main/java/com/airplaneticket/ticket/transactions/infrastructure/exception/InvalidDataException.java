package com.airplaneticket.ticket.transactions.infrastructure.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(final String message) {
        super(message);
    }
}
