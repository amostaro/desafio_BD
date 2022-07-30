package com.totalshakes.wstotalshakes.exception;

public class IngredienteNaoEncontradoException extends Exception {
    public String getMessage() {
        return "Ingrediente não encontrado";
    }
}
