package br.com.gabriel.ifsp.correctionoftest2.exception;

public class EntityAlreadyExists extends RuntimeException {
    public EntityAlreadyExists(String message) {
        super(message);
    }
}
