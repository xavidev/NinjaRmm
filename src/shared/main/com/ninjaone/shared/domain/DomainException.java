package com.ninjaone.shared.domain;

public abstract class DomainException extends RuntimeException {

    private final String errorIdentifier;
    private final String errorMessage;

    public DomainException(String errorIdentifier, String errorMessage) {
        super(errorMessage);

        this.errorIdentifier = errorIdentifier;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorIdentifier;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
