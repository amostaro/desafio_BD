package com.totalshakes.exception;

public class QuantidadeInvalidaException extends IllegalArgumentException {
    public String getMessage() {
        return "Quantidade inválida";
    }
}
