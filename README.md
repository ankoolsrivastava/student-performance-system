<div align="center">

# Student Performance Analysis System

**Java · Spring Boot · PostgreSQL · JavaScript · Chart.js**

A web application for teachers to maintain student records and review academic performance through interactive dashboards and visual reports.

[Live frontend](https://student-performance-web-rpkb.onrender.com) · [Java migration backend](backend-java/README.md)

</div>

---

## Project status

The existing hosted application is retained while the backend is being migrated. The original `backend/` directory is the legacy Node/Express service currently used by the deployed application. The new `backend-java/` directory contains the Java 17 + Spring Boot API being built as the replacement.

**The migration is not yet feature-complete.** The Java API now includes student, marks, attendance, assignments, health, and basic performance-summary endpoints. Teacher management and authentication still need to be ported, and all Java routes must be tested against the current frontend API contract before switching the live service. This branch has not switched the existing frontend or live deployment.

## Technology stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS, JavaScript
- **Charts:** Chart.js
- **Build:** Maven

## Run the Java API locally

Prerequisites: JDK 17+, Maven, and PostgreSQL.

1. Create a PostgreSQL database named `student_performance`.
2. From `backend-java/`, configure database access with environment overrides such as `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD`.
3. Run `mvn spring-boot:run`.
4. Verify `http://localhost:5000/health`.

The checked-in `application.properties` values are local development defaults only. Use environment variables for credentials in other environments; never commit production secrets.

## Java API currently implemented

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/health` | Health check |
| GET | `/api/students` | List students |
| GET | `/api/students/{id}` | Retrieve a student |
| POST | `/api/students` | Create a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |
| GET | `/api/marks` | List marks; optional `studentId` filter |
| POST | `/api/marks` | Create marks |
| PUT/DELETE | `/api/marks/{id}` | Update/delete marks |
| GET | `/api/attendance` | List attendance; optional `studentId` filter |
| POST | `/api/attendance` | Create attendance record |
| PUT/DELETE | `/api/attendance/{id}` | Update/delete attendance |
| GET | `/api/assignments` | List assignments |
| POST | `/api/assignments` | Create assignment |
| PUT/DELETE | `/api/assignments/{id}` | Update/delete assignment |
| GET | `/api/analysis/summary` | Overall student and marks summary |
| GET | `/api/analysis/student/{studentId}` | One student's marks summary |

## Migration checklist

- [x] Create a separate Spring Boot application and Maven build.
- [x] Add PostgreSQL/JPA configuration and student CRUD endpoints.
- [x] Add marks, attendance, and assignment APIs.
- [x] Add basic performance summary endpoints, health check, and CORS configuration.
- [ ] Port and validate teacher and authentication flows.
- [ ] Verify all frontend API contracts and run integration tests.
- [ ] Configure and test a separate Render service before any production cutover.

The Java migration is being developed on a separate branch to avoid breaking the currently deployed application. The Maven build and integration tests have not yet been run in this environment.
