package com.example.urlshortenerservice.rest;

import com.example.urlshortenerservice.model.ShorteningRequest;
import com.example.urlshortenerservice.model.Url;
import com.example.urlshortenerservice.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
  private final UrlService urlService;

  @PostMapping("/shorten")
  Url shortenUrl(@Valid @RequestBody ShorteningRequest request) {
    return urlService.shorten(request);
  }

  @GetMapping("/{hash}")
  Url getByHash(@PathVariable String hash) {
    return urlService.getByHash(hash);
  }

  @DeleteMapping
  void deleteAll() {
    urlService.deleteAll();
  }

}
