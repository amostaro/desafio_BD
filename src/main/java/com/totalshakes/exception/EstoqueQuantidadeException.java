package com.totalshakes.exception;

public class EstoqueQuantidadeException extends IllegalArgumentException {
    public String getMessage() {
        return "Estoque com quantidade baixa";
    }
}
