package com.example.urlshortenerservice.repository;

import com.example.urlshortenerservice.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
  Url findByHash(String hash);
}
