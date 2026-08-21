# BuddyDrop Backend

This is the Java + Spring Boot backend starter for BuddyDrop.

## Tech stack
- Java 21
- Spring Boot 4.0.0
- PostgreSQL
- Redis
- Kafka
- Spring Security
- Spring Data JPA
- Actuator

## Local development setup

1. Start infrastructure services:
   ```bash
   docker compose up -d
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Health endpoint:
   ```bash
   curl http://localhost:8081/api/health
   ```

## Default credentials
The app uses HTTP basic auth for starter development.
- Username: `admin`
- Password: `admin123`

## Notes
The app is intentionally configured as a starter with basic security and a simple health endpoint. This is the foundation for a modular microservice design that can later split into separate services for auth, catalog, orders, and delivery.
