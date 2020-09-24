package com.bercut.labs.shortener.services;

public class ShortUrlNotFoundException extends UrlShortenerServiceException {
    public ShortUrlNotFoundException() {
    }

    public ShortUrlNotFoundException(String message) {
        super(message);
    }

    public ShortUrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShortUrlNotFoundException(Throwable cause) {
        super(cause);
    }

    public ShortUrlNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
