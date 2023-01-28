package com.example.urlshortenerservicereactive.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShorteningRequest {
  @NotBlank
  private String originalUrl;

}
