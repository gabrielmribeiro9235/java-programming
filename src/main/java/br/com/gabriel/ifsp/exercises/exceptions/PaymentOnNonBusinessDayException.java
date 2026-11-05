package br.com.gabriel.ifsp.exercises.exceptions;

public class PaymentOnNonBusinessDayException extends RuntimeException {
    public PaymentOnNonBusinessDayException(String message) {
        super(message);
    }
}
