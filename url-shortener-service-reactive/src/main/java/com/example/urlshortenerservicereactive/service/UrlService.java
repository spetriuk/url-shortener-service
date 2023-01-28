package com.example.urlshortenerservicereactive.service;

import com.example.urlshortenerservicereactive.model.ShorteningRequest;
import com.example.urlshortenerservicereactive.model.Url;
import com.example.urlshortenerservicereactive.repository.UrlRepository;
import com.example.urlshortenerservicereactive.util.HashingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UrlService {
  private final UrlRepository urlRepository;

  public Mono<Url> shorten(ShorteningRequest request) {
    var url = Url.builder()
        .originalUrl(request.getOriginalUrl())
        .hash(HashingUtil.hash(request.getOriginalUrl()))
        .build();

    return urlRepository.save(url);
  }

//  @Cacheable
  public Mono<Url> getByHash(String hash) {
    return urlRepository.findByHash(hash);
  }

  public Mono<Void> deleteAll() {
    return urlRepository.deleteAll();
  }

}
