package br.com.gabriel.ifsp.exercises.jdbc.domain.exception;

public class PaymentOnNonBusinessDayException extends RuntimeException {
    public PaymentOnNonBusinessDayException(String message) {
        super(message);
    }
}
