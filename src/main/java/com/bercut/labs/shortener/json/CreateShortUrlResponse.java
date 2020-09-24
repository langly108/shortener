package com.bercut.labs.shortener.json;

public class CreateShortUrlResponse {


    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String shortUrl;

    // {
    //      "shortUrl: "http://localhost:8100"/ff657ad"
    // }
}
