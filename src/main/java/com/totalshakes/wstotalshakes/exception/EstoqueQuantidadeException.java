package com.totalshakes.wstotalshakes.exception;

public class EstoqueQuantidadeException extends Exception {
    public String getMessage() {
        return "Estoque com quantidade baixa";
    }
}
