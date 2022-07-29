package com.totalshakes.exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException {
    public String getMessage() {
        return "Ingrediente não encontrado";
    }
}
