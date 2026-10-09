# Student Performance Analysis API (Java)

This is the Java/Spring Boot migration backend for the Student Performance Analysis System. It uses Java 17, Spring Boot, Spring Data JPA, PostgreSQL, and Maven. The existing frontend uses JavaScript and Chart.js.

## Run locally

1. Install JDK 17+ and PostgreSQL.
2. Create a database named `student_performance`.
3. Set `DB_USERNAME` and `DB_PASSWORD` if your local PostgreSQL credentials differ from the defaults.
4. From this directory run `mvn spring-boot:run`.

For a hosted database, set `DATABASE_URL` to a PostgreSQL JDBC URL such as `jdbc:postgresql://HOST:5432/DBNAME`, and set `DB_USERNAME` / `DB_PASSWORD` separately. If your hosting provider supplies a URL beginning with `postgres://`, convert it to JDBC format before using it as `DATABASE_URL`.

## Current endpoints

- `GET /health` — health check
- `GET /api/students` — list students
- `GET /api/students/{id}` — retrieve one student
- `POST /api/students` — create a student
- `PUT /api/students/{id}` — update a student
- `DELETE /api/students/{id}` — delete a student

Example request body:
```json
{
  "name": "Aarav Sharma",
  "email": "aarav@example.com",
  "className": "10-A",
  "rollNumber": "10"
}
```

## Migration notes

This is an initial Java API foundation, not yet a feature-complete replacement for every legacy Node/Express route. The old `backend/` is intentionally preserved during migration so existing live deployment is not silently broken. Before switching the frontend or Render service to this backend, migrate and verify the teacher, marks, attendance, assignments, authentication, and analysis endpoints against the current frontend contract. Do not expose demo credentials or use schema auto-update as a production migration strategy.
