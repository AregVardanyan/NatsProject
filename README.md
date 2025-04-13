# Spring Boot + PostgreSQL + NATS Messaging

This project is a simple Spring Boot application that connects to a PostgreSQL database and listens to a NATS message broker. It consumes messages published to a specific NATS subject and persists them into a PostgreSQL table named `messages`.

## Prerequisites

- **PostgreSQL must be installed** and a database must be created (default name: `nats`).
- **Docker and Docker Compose installed** on your system.

---

## Getting Started

1. **Ensure your PostgreSQL database exists** and is running. Create a database named `nats` (or use another name and update the environment variables accordingly).

2. **Navigate to the root of the Spring Boot project** (where the `pom.xml` file is located).

3. **Run the application using Docker Compose**, replacing credentials with your actual PostgreSQL username, password, and database name:

   ```bash
   POSTGRES_USER=postgres \
   POSTGRES_PASSWORD=passs \
   POSTGRES_DB=nats_db \
   DB_URL=jdbc:postgresql://postgres:5432/nats_db \
   DB_USER=postgres \
   DB_PASSWORD=pass \
   docker-compose up --build
