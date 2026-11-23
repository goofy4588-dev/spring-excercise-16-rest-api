
A simple REST API for managing products, built with Spring Boot.


Adithyadev Veliyathuparambil Manoj – 77242


- Java
- Spring Boot 4.1.2
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Swagger UI (springdoc-openapi)
- Maven

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/v1/products` | Create a product |
| GET | `/api/v1/products` | Get all products |
| GET | `/api/v1/products/{id}` | Get a product by id |
| PUT | `/api/v1/products/{id}` | Update a product |
| DELETE | `/api/v1/products/{id}` | Delete a product |

A request for a product that does not exist returns `404` with an error message.

1. Open the project in IntelliJ IDEA.
2. Run `FirstRestApiApplication`.
3. Swagger UI: `http://localhost:8080/swagger-ui/index.html`
4. H2 console: `http://localhost:8080/console` (JDBC URL: `jdbc:h2:mem:testdb`)