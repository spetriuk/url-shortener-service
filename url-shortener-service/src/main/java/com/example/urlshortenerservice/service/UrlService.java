package com.example.urlshortenerservice.service;

import com.example.urlshortenerservice.model.ShorteningRequest;
import com.example.urlshortenerservice.model.Url;
import com.example.urlshortenerservice.repository.UrlRepository;
import com.example.urlshortenerservice.util.HashingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {
  private final UrlRepository urlRepository;

  public Url shorten(ShorteningRequest request) {
    var url = Url.builder()
        .originalUrl(request.getOriginalUrl())
        .hash(HashingUtil.hash(request.getOriginalUrl()))
        .build();

    return urlRepository.save(url);
  }

//  @Cacheable
  public Url getByHash(String hash) {
    return urlRepository.findByHash(hash);
  }

  public void deleteAll() {
    urlRepository.deleteAll();
  }

}
