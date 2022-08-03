package com.totalshakes.wstotalshakes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IngredienteJaCadastradoException extends RuntimeException {
    public IngredienteJaCadastradoException(String message) {
        super(message);
    }
}
