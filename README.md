# Student Performance Analysis System

**Java · Spring Boot · PostgreSQL · JavaScript · Chart.js**

A student performance web application with a Java/Spring Boot REST API, PostgreSQL persistence, and a browser-based interface with Chart.js visualisations.

## Technology stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA, Maven
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS, JavaScript
- **Charts:** Chart.js

## Run locally

### Requirements

- JDK 17 or newer
- Maven 3.9+ (or use a Maven wrapper if one is added)
- PostgreSQL 14 or newer

### 1. Create the local database

Open PostgreSQL (for example, through pgAdmin or psql) and create a database:

```sql
CREATE DATABASE student_performance;
```

### 2. Configure your local database credentials

The defaults in `backend/src/main/resources/application.properties` are for a standard local PostgreSQL setup. If your local PostgreSQL username or password differs, set environment variables before running the application:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

Do not put real or production credentials in Git.

### 3. Start the API

From the repository root:

```bash
cd backend
mvn spring-boot:run
```

The API starts at `http://localhost:5000`. Check `http://localhost:5000/health` to verify it is running. Hibernate creates or updates tables in the local database automatically; use a dedicated development database.

### 4. Open the frontend

Open the frontend's `index.html` using a local web server where possible. If the frontend uses a configured API base URL, point it to `http://localhost:5000`. The API allows common localhost development origins.

## API endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/health` | Health check |
| GET | `/api/students` | List students |
| GET | `/api/students/{id}` | Get one student |
| POST | `/api/students` | Create a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |
| GET | `/api/marks` | List marks; optional `studentId` filter |
| POST | `/api/marks` | Add a mark |
| PUT / DELETE | `/api/marks/{id}` | Update or delete a mark |
| GET | `/api/attendance` | List attendance; optional `studentId` filter |
| POST | `/api/attendance` | Add an attendance record |
| PUT / DELETE | `/api/attendance/{id}` | Update or delete attendance |
| GET | `/api/assignments` | List assignments |
| POST | `/api/assignments` | Add an assignment |
| PUT / DELETE | `/api/assignments/{id}` | Update or delete an assignment |
| GET | `/api/analysis/summary` | Overall performance summary |
| GET | `/api/analysis/student/{studentId}` | Individual student summary |

The application is intended to be run and tested locally. No deployment is required.
