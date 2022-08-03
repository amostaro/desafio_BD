package com.totalshakes.wstotalshakes.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IngredienteNaoEncontradoException extends RuntimeException {
    public IngredienteNaoEncontradoException(String message) {
        super(message);
    }
}
