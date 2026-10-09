# Backend

The REST API is built with Java 17, Spring Boot, Spring Data JPA, and PostgreSQL.

## Run locally

1. Install JDK 17+, Maven, and PostgreSQL.
2. Create a local database named `student_performance`.
3. If your PostgreSQL credentials are not `postgres` / `postgres`, set `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD`. You can also set `SPRING_DATASOURCE_URL`.
4. From this directory, run:

```bash
mvn spring-boot:run
```

The API listens on port 5000 by default. Visit `http://localhost:5000/health` to check it.

Use a dedicated local development database. Hibernate's `ddl-auto=update` setting creates or updates tables for the current entity models; it is not a replacement for a production database migration process.
