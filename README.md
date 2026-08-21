# BuddyDrop Backend

BuddyDrop backend is a Spring Boot application that provides the API foundation for the BuddyDrop platform. It includes service setup for PostgreSQL, Redis, Kafka, and basic security while staying easy to run in a local development environment.

## Tech stack

- Java 21
- Spring Boot 4.0.0
- Maven
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Redis
- Kafka
- Spring Security
- Validation
- Spring Boot Actuator
- Docker + Docker Compose

## Project requirements

Before running the project, make sure you have:

- JDK 21 or newer
- Maven or the included Maven wrapper (`mvnw` / `mvnw.cmd`)
- Docker and Docker Compose
- Git

## Quick start

1. Clone the repository

   ```bash
   git clone <repository-url>
   cd backend
   ```

2. Start the required infrastructure services

   This project uses PostgreSQL, Redis, and Kafka for local development.

   ```bash
   docker compose up -d
   ```

   This starts:
   - PostgreSQL on `localhost:5432`
   - Redis on `localhost:6379`
   - Zookeeper on `localhost:2181`
   - Kafka on `localhost:9092`

3. Configure environment variables

   Copy the sample environment file if needed:

   ```bash
   cp .env.example .env
   ```

   The app reads values from environment variables with defaults defined in `src/main/resources/application.yml`.

   Example values:

   ```env
   DB_URL=jdbc:postgresql://localhost:5432/buddydrop
   DB_USERNAME=buddydrop
   DB_PASSWORD=buddydrop
   KAFKA_BOOTSTRAP_SERVERS=localhost:9092
   REDIS_HOST=localhost
   REDIS_PORT=6379
   REDIS_PASSWORD=
   APP_USERNAME=admin
   APP_PASSWORD=admin123
   SERVER_PORT=8081
   ```

4. Build the project

   ```bash
   ./mvnw clean install
   ```

5. Run the application

   ```bash
   ./mvnw spring-boot:run
   ```

   By default, the application runs on:

   ```text
   http://localhost:8081
   ```

## Default application configuration

The project uses the following default values when no environment variables are set:

| Setting | Default |
| --- | --- |
| App name | `buddydrop-backend` |
| Server port | `8081` |
| PostgreSQL URL | `jdbc:postgresql://localhost:5432/buddydrop` |
| PostgreSQL username | `buddydrop` |
| PostgreSQL password | `buddydrop` |
| Redis host | `localhost` |
| Redis port | `6379` |
| Kafka brokers | `localhost:9092` |
| Default admin username | `admin` |
| Default admin password | `admin123` |

## Security

The app is configured with basic authentication for local development.

- Username: `admin`
- Password: `admin123`

## Health and monitoring

Spring Boot Actuator is included. Health checks can be accessed at:

```bash
curl http://localhost:8081/actuator/health
```

## Project structure

```text
backend/
├── .env.example
├── .gitignore
├── docker-compose.yml
├── mvnw
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
└── target/
```

## Common troubleshooting

### Application fails to start

Check whether these services are running:

```bash
docker ps
```

If PostgreSQL, Redis, or Kafka are not running, start them again:

```bash
docker compose up -d
```

### Database connection errors

Verify your DB settings in the environment variables or `.env` file. The default database name is `buddydrop` and the default credentials are `buddydrop` / `buddydrop`.

### Port already in use

If `8081` is already occupied, update `SERVER_PORT` in your environment variables:

```env
SERVER_PORT=8082
```

## Notes

This project is structured as a starter backend for BuddyDrop and is designed to be extended with domain-specific modules such as authentication, customer management, orders, and delivery flows.

For a clean repository, generated folders like `target/` and IDE metadata are ignored by Git.
