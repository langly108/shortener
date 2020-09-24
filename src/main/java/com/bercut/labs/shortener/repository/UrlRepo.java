package com.bercut.labs.shortener.repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "urls_map")
public class UrlRepo {
    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name="urls_map_id_seq", sequenceName = "urls_map_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urls_map_id_seq")
    private Long id;

    @Column(name = "short_key")
    private String shortKey;

    @Column(name = "long_url")
    private String longUrl;

}
