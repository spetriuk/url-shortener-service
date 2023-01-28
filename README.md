# URL Shortener Service

### About

This is a simple project for comparing the performance of the Spring Boot REST APIs. The datanase is `MongoDB`. It include the simple rest service in 2 versions and [Gatlig](https://gatling.io/) based performance tests:

- [url-shortener-service](./url-shortener-service) - Spring Web REST
- [url-shortener-service-reactive](./url-shortener-service-reactive) - Spring WebFlux REST
- [performance-test](./performance-test) - Gatling tests written in Scala

The goal is to compare the Spring Web and Spring WebFlux using the Gatling tests for the high demand data - URLs that are stored in the DB and accessible by the short link (hash). Also, the cache (`@Cacheble` ) impact should be tested on both projects as well.
