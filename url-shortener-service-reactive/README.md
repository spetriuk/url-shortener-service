# Url Shortener Service

>Spring WebFlux version

This service is a simple URL shortener that allows users to shorten long URLs and retrieve the original URL from the shortened version.

### Features
- Shorten long URLs into a unique, shortened version
- Retrieve the original URL from the shortened version
- Delete all shortened URLs

### API Endpoints
The following API endpoints are available for interacting with the service:

#### POST /api/url/shorten
Shortens a long URL.

##### Request Body
```json
{
  "originalUrl": "https://example.com"
}
```

##### Response
```json
{
  "originalUrl": "https://example.com",
  "hash": "abc123"
}
```

#### GET /api/url/{hash}
Retrieves the original URL from the given hash.

##### Response
```json
{
  "originalUrl": "https://example.com",
  "hash": "abc123"
}
```

#### DELETE /api/url/
Deletes all shortened URLs

### Technologies Used
- Spring Boot
- Jakarta Validation
- Lombok
- MongoDB



