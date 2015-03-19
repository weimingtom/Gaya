package com.ernestas.gaya.Exceptions;

public class InvalidFileException extends GayaException {

    public InvalidFileException() {
        super();
    }

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(String message, Throwable clause) {
        super(message, clause);
    }

    public InvalidFileException(Throwable clause) {
        super(clause);
    }

}
