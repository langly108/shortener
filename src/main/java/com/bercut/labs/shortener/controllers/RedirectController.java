package com.bercut.labs.shortener.controllers;

import com.bercut.labs.shortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@Controller
public class RedirectController {

    @Autowired
    private UrlShortenerService service;

    //http://localhost:8100/asd
    @RequestMapping("/convert/{key}")
    public void redirect(@PathVariable("key") String key, HttpServletResponse resp) {
        String longUrl = service.findLongUrl(key);
        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        resp.addHeader("Location", longUrl);
    }

}
