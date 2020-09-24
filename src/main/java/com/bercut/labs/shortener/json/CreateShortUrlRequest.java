package com.bercut.labs.shortener.json;

public class CreateShortUrlRequest {

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    private String longUrl;

    //{
    // "longUrl": "www.yandex.ru"
    // }
}
