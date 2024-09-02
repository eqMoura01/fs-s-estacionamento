package com.eqmoura.estacionamento.exceptions;

public class VeiculoException extends Exception {
    public VeiculoException(String message) {
        super(message);
    }

    public VeiculoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
