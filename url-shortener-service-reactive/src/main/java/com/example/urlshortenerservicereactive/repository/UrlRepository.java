package com.example.urlshortenerservicereactive.repository;

import com.example.urlshortenerservicereactive.model.Url;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UrlRepository extends ReactiveMongoRepository<Url, String> {
  Mono<Url> findByHash(String hash);
}
