package com.bercut.labs.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlRepository extends JpaRepository<UrlRepo, Integer> {

    List<UrlRepo> findByShortKey(String shortKey);
}
