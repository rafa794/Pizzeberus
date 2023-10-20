package com.hiberus.excepciones;

public class PizzaNotFoundException extends Throwable {
    public PizzaNotFoundException(String message) {
        super(message);
    }
}
