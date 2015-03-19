package com.ernestas.gaya.Exceptions;

public class FileHandlingException extends GayaException {

    public FileHandlingException() {
        super();
    }

    public FileHandlingException(String message) {
        super(message);
    }

    public FileHandlingException(String message, Throwable clause) {
        super(message, clause);
    }

    public FileHandlingException(Throwable clause) {
        super(clause);
    }

}
