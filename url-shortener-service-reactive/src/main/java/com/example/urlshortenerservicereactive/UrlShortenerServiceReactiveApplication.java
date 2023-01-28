package com.example.urlshortenerservicereactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class UrlShortenerServiceReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerServiceReactiveApplication.class, args);
	}

}
