package com.example.urlshortenerservicereactive.rest;

import com.example.urlshortenerservicereactive.model.ShorteningRequest;
import com.example.urlshortenerservicereactive.model.Url;
import com.example.urlshortenerservicereactive.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
  private final UrlService urlService;

  @PostMapping("/shorten")
  Mono<Url> shortenUrl(@Valid @RequestBody ShorteningRequest request) {
    return urlService.shorten(request);
  }

  @GetMapping("/{hash}")
  Mono<Url> getByHash(@PathVariable String hash) {
    return urlService.getByHash(hash);
  }

  @DeleteMapping
  Mono<Void> deleteAll() {
    return urlService.deleteAll();
  }

}
