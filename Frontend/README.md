# Banking CRUD Frontend

## Overview

Banking CRUD Frontend is a web-based user interface developed using HTML, CSS, and JavaScript.

The frontend integrates with the Spring Boot Banking CRUD API and allows users to perform banking operations through a simple browser interface.

The application supports:

- Customer Management
- Account Management
- Transaction History
- Beneficiary Management

The frontend communicates with the backend using REST APIs.

---

## Technologies Used

- HTML5
- CSS3
- JavaScript
- Fetch API
- Spring Boot REST APIs
- PostgreSQL (through backend)

---

## Project Architecture

```text
Browser
    │
    ▼
HTML / CSS / JavaScript
    │
    ▼
Spring Boot REST API
    │
    ▼
PostgreSQL Database
```

---

## Project Structure

```text
frontend

├── index.html
├── customers.html
├── create-customer.html
├── accounts.html
├── account-details.html
├── transactions.html
├── beneficiaries.html
├── add-beneficiary.html

├── css
│   └── style.css

└── js
    ├── config.js
    ├── customers.js
    ├── accounts.js
    ├── transactions.js
    └── beneficiaries.js
```

---

## Features

### Customer Pages

- View Customer List
- Create New Customer
- Customer Validation

### Account Pages

- View Account List
- View Account Details

### Transaction Pages

- View Transaction History by Account

### Beneficiary Pages

- View Beneficiary List
- Add New Beneficiary

---

## Environment Configuration

Backend API URL is configured in:

```text
js/config.js
```

```javascript
const API_BASE_URL = "http://localhost:8080/api";
```

---

## Running the Frontend

### Prerequisites

Make sure the backend application is running:

```text
http://localhost:8080
```

### Open the Frontend

Open:

```text
frontend/index.html
```

using VS Code Live Server.

Right Click:

```text
index.html
```

Select:

```text
Open With Live Server
```

Frontend URL:

```text
http://127.0.0.1:5500
```

---

## Pages

### Home Page

```text
index.html
```

Provides navigation to all modules.

### Customer List

```text
customers.html
```

Displays all customers from:

```http
GET /api/customers
```

### Create Customer

```text
create-customer.html
```

Creates a new customer using:

```http
POST /api/customers
```

### Account List

```text
accounts.html
```

Displays all accounts using:

```http
GET /api/accounts
```

### Account Details

```text
account-details.html
```

Displays account information using:

```http
GET /api/accounts/{accountId}
```

### Transaction History

```text
transactions.html
```

Displays transactions using:

```http
GET /api/accounts/{accountId}/transactions
```

### Beneficiary List

```text
beneficiaries.html
```

Displays all beneficiaries using:

```http
GET /api/beneficiaries
```

### Add Beneficiary

```text
add-beneficiary.html
```

Creates a beneficiary using:

```http
POST /api/beneficiaries
```

---

## Validation

Frontend validation includes:

- Required field validation
- Email format validation
- Phone number validation
- Empty input validation

Backend validation is also enforced through Spring Validation.

---

## Error Handling

The frontend handles:

- API connection failures
- Validation errors
- Resource not found errors
- Server-side errors

Error messages are displayed to the user through alerts and validation messages.

---

## Request Flow

```text
User Action
      │
      ▼
HTML Form
      │
      ▼
JavaScript Fetch API
      │
      ▼
Spring Boot Controller
      │
      ▼
Service Layer
      │
      ▼
Repository Layer
      │
      ▼
PostgreSQL Database
      │
      ▼
JSON Response
      │
      ▼
Frontend UI Update
```

---

## Testing

The frontend was tested against the Banking CRUD REST APIs.

Verified flows:

- Create Customer
- View Customers
- View Accounts
- View Account Details
- View Transaction History
- View Beneficiaries
- Add Beneficiary

---

