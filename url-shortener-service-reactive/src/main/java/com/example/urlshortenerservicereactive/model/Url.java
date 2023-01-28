package com.example.urlshortenerservicereactive.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Url {
  @Id
  private String hash;
  private String originalUrl;

}
