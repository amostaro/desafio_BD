package com.totalshakes.wstotalshakes.exception;

public class IngredienteJaCadastradoException extends Exception {
    public String getMessage() {
        return "Ingrediente já cadastrado";
    }
}
