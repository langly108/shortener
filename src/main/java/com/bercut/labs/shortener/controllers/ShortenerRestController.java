package com.bercut.labs.shortener.controllers;

import com.bercut.labs.shortener.json.CreateShortUrlRequest;
import com.bercut.labs.shortener.json.CreateShortUrlResponse;
import com.bercut.labs.shortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerRestController {

    @Autowired
    private UrlShortenerService shortenerService;

    @RequestMapping("/hellourl")
    public String hello(String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = "/shorturl", method = RequestMethod.POST)
    public CreateShortUrlResponse create(@RequestBody CreateShortUrlRequest req) {
        String shortUrl = shortenerService.shorten(req.getLongUrl());
        CreateShortUrlResponse resp = new CreateShortUrlResponse();
        resp.setShortUrl(shortUrl);
        return resp;
    }
}
