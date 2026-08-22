# Banking CRUD API

## Overview

Banking CRUD API is a Spring Boot backend application that provides REST APIs for managing banking operations.

The application supports:

- Customer Management
- Account Management
- Transaction Management
- Beneficiary Management

Data is stored in PostgreSQL and accessed using Hibernate/JPA.

---

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman

---

## Project Architecture

```text
Client (Postman)
        │
        ▼
Controller Layer
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
PostgreSQL Database
```

---

## Project Structure

```text
src/main/java/com/Banfico/BankingCrud

├── controller
├── service
├── repository
├── entity
└── exception
```

---

## Features

### Customer APIs

- Create Customer
- Get All Customers
- Get Customer By ID

### Account APIs

- Create Account
- Get All Accounts
- Get Account By ID

### Transaction APIs

- Create Transaction
- Get Transactions by Account

### Beneficiary APIs

- Create Beneficiary
- Get All Beneficiaries
- Delete Beneficiary

---

## Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE banking_crud_db;
```

Configure the database in:

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/banking_crud_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

---

## Running the Application

### Build the Project

```powershell
.\mvnw.cmd clean package
```

Expected:

```text
BUILD SUCCESS
```

### Run the Application

```powershell
.\mvnw.cmd spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

---

## API Endpoints

### Customers

| Method | Endpoint |
|----------|----------|
| POST | /api/customers |
| GET | /api/customers |
| GET | /api/customers/{id} |

### Accounts

| Method | Endpoint |
|----------|----------|
| POST | /api/accounts |
| GET | /api/accounts |
| GET | /api/accounts/{accountId} |

### Transactions

| Method | Endpoint |
|----------|----------|
| POST | /api/accounts/{accountId}/transactions |
| GET | /api/accounts/{accountId}/transactions |

### Beneficiaries

| Method | Endpoint |
|----------|----------|
| POST | /api/beneficiaries |
| GET | /api/beneficiaries |
| DELETE | /api/beneficiaries/{id} |

---

## Sample Request

### Create Customer

Request:

```json
{
  "name": "Reveena",
  "email": "reveena@gmail.com",
  "phone": "9876543210"
}
```

Response:

```json
{
  "id": 1,
  "name": "Reveena",
  "email": "reveena@gmail.com",
  "phone": "9876543210"
}
```

---

## Validation

The application validates incoming requests using Spring Validation.

Validation includes:

- Name cannot be blank
- Email must be valid
- Phone number must contain exactly 10 digits

---

## Exception Handling

Global exception handling is implemented using:

```java
@RestControllerAdvice
```

Handled errors:

- HTTP 400 – Validation Errors
- HTTP 404 – Resource Not Found

Example:

```json
{
  "status": 404,
  "message": "Customer not found with id: 100"
}
```

---

## Testing

All APIs were tested using Postman.

Postman Collection:

```text
postman/Banking CRUD API.postman_collection.json
```

---

## Author

**REVEENA M**

BE Computer Science and Engineering  
Government College of Technology, Coimbatore
