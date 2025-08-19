# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Ultra Tutor API is a Spring Boot 3.5.4 REST API built with Java 21 that manages vocabulary words for language learning. The application uses PostgreSQL for persistence and follows a standard layered architecture.

## Development Commands

### Building and Running
```bash
# Build the project
./mvnw clean compile

# Run tests
./mvnw test

# Run the application
./mvnw spring-boot:run

# Package the application
./mvnw package
```

### Database Setup
```bash
# Start PostgreSQL and pgAdmin using Docker Compose
docker-compose up -d

# Stop the database services
docker-compose down
```

The application requires environment variables for database connection:
- `POSTGRES_DB` - Database name
- `POSTGRES_USER` - Database username  
- `POSTGRES_PASSWORD` - Database password
- `PGADMIN_EMAIL` - pgAdmin login email
- `PGADMIN_PASSWORD` - pgAdmin login password

## Architecture

### Package Structure
- `com.ultra_tutor.ultra_tutor_api` - Root package (note: uses underscores due to package naming constraints)
- `controller/` - REST controllers exposing API endpoints
- `service/` - Business logic layer
- `repository/` - Data access layer using Spring Data JPA
- `model/` - Entity classes, DTOs, and command objects
- `config/` - Application configuration classes
- `mappings/` - ModelMapper converters for entity-DTO mapping

### Key Components

**Word Management System:**
- `Word` entity represents vocabulary words with context and source URL
- Uses UUID as primary key with `@GeneratedValue(generator = "UUID")`
- Validation annotations: `@Size(min = 1)` for selectedText, `@URL` for url field
- ModelMapper handles entity-DTO conversions with custom converters

**API Endpoints:**
- Base path: `/api/v1/words`
- POST `/api/v1/words` - Create new word
- GET `/api/v1/words` - Retrieve all words

**Database:**
- PostgreSQL with JPA/Hibernate
- Table name: "Words" (explicitly mapped with `@Table`)
- Development profile available in `application-dev.properties`

### Technologies Used
- Spring Boot 3.5.4 with Spring Web, Data JPA, Security, Validation
- PostgreSQL driver
- Lombok for reducing boilerplate
- ModelMapper 3.2.4 for entity-DTO mapping
- Maven for build management
- Docker Compose for local development database

## Development Notes

- The original package name was invalid (`com.ultra-tutor.ultra-tutor-api`) and uses underscores instead
- ModelMapper is configured as a Spring bean with automatic converter discovery
- Application uses standard Spring Boot auto-configuration
- Lombok annotations reduce boilerplate code (`@RequiredArgsConstructor`, `@Getter`, `@Setter`)
- Uses Jakarta EE annotations (Jakarta Persistence API, Jakarta Validation)