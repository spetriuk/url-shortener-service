package com.example.urlshortenerservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShorteningRequest {
  @NotBlank
  private String originalUrl;

}
