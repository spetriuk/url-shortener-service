# URL Shortener Service

### About

This is a simple project that compares the performance of Spring Boot REST APIs. The database is MongoDB and it includes simple REST services in two versions, as well as Gatling-based performance tests:

- [url-shortener-service](./url-shortener-service) - Spring Web REST
- [url-shortener-service-reactive](./url-shortener-service-reactive) - Spring WebFlux REST
- [performance-test](./performance-test) - Gatling tests written in Scala

The goal of this project is to compare the performance of Spring Web and Spring WebFlux using Gatling tests for high-demand data, such as URLs that are stored in the DB and accessible by short links (hashes). Additionally, the impact of caching (`@Cacheable`) will be tested on both projects.
