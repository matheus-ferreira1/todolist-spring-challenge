package br.com.matheusferreira.desafiotodolist.exception;

public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String message) {
        super(message);
    }

}
