package com.ernestas.gaya.Exceptions;

import java.io.IOException;

public class GayaException extends Exception {

    public GayaException() {
        super();
    }

    public GayaException(String message) {
        super(message);
    }

    public GayaException(String message, Throwable clause) {
        super(message, clause);
    }

    public GayaException(Throwable clause) {
        super(clause);
    }

}
