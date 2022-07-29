package com.totalshakes.wstotalshakes.exception;

public class EstoqueQuantidadeException extends IllegalArgumentException {
    public String getMessage() {
        return "Estoque com quantidade baixa";
    }
}
