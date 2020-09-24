package com.bercut.labs.shortener.services;

import com.bercut.labs.shortener.json.CreateShortUrlRequest;
import com.bercut.labs.shortener.repository.UrlRepo;
import com.bercut.labs.shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Service for shorting urls
 */
@Service
public class UrlShortenerService {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private UrlRepository urlRepository;

    public String shorten(String longUrl) {
        String shortKey = Integer.toHexString(longUrl.hashCode());
        UrlRepo u = new UrlRepo();
        u.setShortKey(shortKey);
        u.setLongUrl(longUrl);
        urlRepository.save(u);
        return "http://localhost:" + serverPort + "/" + shortKey;
    }


    /**
     * Finds long url by key
     * @param key short key that was created in {@link com.bercut.labs.shortener.controllers.ShortenerRestController#create(CreateShortUrlRequest)}
     * @return long url
     * @throws ShortUrlNotFoundException if not found
     */
    public String findLongUrl(String key) throws UrlShortenerServiceException {
        String longUrl = urlRepository.findByShortKey(key).get(0).getLongUrl();
        if (longUrl == null) {
            throw new ShortUrlNotFoundException(key);
        }
        return longUrl;
    }
}
