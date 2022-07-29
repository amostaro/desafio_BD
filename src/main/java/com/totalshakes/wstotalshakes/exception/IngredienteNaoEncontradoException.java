package com.totalshakes.wstotalshakes.exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException {
    public String getMessage() {
        return "Ingrediente não encontrado";
    }
}
