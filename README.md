# 🏥 Hospital Management System

<p align="center">
  <b>A Spring Boot REST API for managing hospital operations</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Spring%20Security-JWT-blue" alt="Spring Security">
  <img src="https://img.shields.io/badge/Hibernate-JPA-red" alt="Hibernate">
  <img src="https://img.shields.io/badge/MySQL-8.x-blue" alt="MySQL">
  <img src="https://img.shields.io/badge/Maven-Build-red" alt="Maven">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-green" alt="Swagger">
</p>

---

## 📌 About the Project

**Hospital Management System** is a backend REST API application developed using **Java and Spring Boot**.

The project provides APIs for managing users, patients, doctors, departments, and appointments. It also demonstrates authentication and authorization using **Spring Security and JWT**.

The main purpose of this project is to understand how a real-world Spring Boot backend can be structured using a **layered architecture**.

---

## ✨ Features

* 👤 User management
* 🔐 JWT-based authentication
* 🛡️ Role-based authorization
* 🧑‍⚕️ Doctor management
* 🧑‍🦽 Patient management
* 🏥 Department management
* 📅 Appointment management
* ✅ Request validation
* ⚠️ Global exception handling
* 📄 DTO-based request and response handling
* 📑 Pagination
* 📊 Standardized API responses
* 📚 Swagger / OpenAPI documentation
* 🗄️ MySQL database integration
* 🧪 API testing using Postman

---

# 🛠️ Technologies Used

| Technology               | Purpose                        |
| ------------------------ | ------------------------------ |
| ☕ **Java**               | Programming language           |
| 🌱 **Spring Boot**       | Backend framework              |
| 🌐 **Spring Web**        | REST API development           |
| 🔐 **Spring Security**   | Authentication & authorization |
| 🎫 **JWT**               | Token-based authentication     |
| 🗄️ **Spring Data JPA**  | Database access                |
| 🧩 **Hibernate**         | ORM                            |
| 🐬 **MySQL**             | Relational database            |
| 📦 **Maven**             | Build & dependency management  |
| 📚 **Swagger / OpenAPI** | API documentation              |
| 🧪 **Postman**           | API testing                    |
| 🔧 **Git**               | Version control                |
| 🐙 **GitHub**            | Source code hosting            |

---

# 🏗️ Architecture

The project follows a **layered architecture**.

```text
                    🌐 Client / Postman
                           │
                           ▼
                  ┌─────────────────┐
                  │   Controller    │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │    Service      │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │   Repository    │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │     MySQL       │
                  └─────────────────┘
```

### 🔹 Controller Layer

Handles HTTP requests and responses.

### 🔹 Service Layer

Contains business logic and coordinates application operations.

### 🔹 Repository Layer

Handles communication with the database using Spring Data JPA.

### 🔹 Entity Layer

Represents database entities.

### 🔹 DTO Layer

Transfers request and response data without directly exposing entities.

### 🔹 Exception Layer

Provides centralized exception handling.

### 🔹 Security Layer

Handles JWT authentication and Spring Security authorization.

---

# 📂 Project Structure

```text
hospitalmanager
│
├── 📁 src
│   │
│   ├── 📁 main
│   │   │
│   │   ├── 📁 java
│   │   │   └── 📁 hospitalmanager
│   │   │       │
│   │   │       ├── 📁 config
│   │   │       │   ├── OpenApiConfig.java
│   │   │       │   └── SecurityConfig.java
│   │   │       │
│   │   │       ├── 📁 controller
│   │   │       │   ├── AppointmentController.java
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── DepartmentController.java
│   │   │       │   ├── DoctorController.java
│   │   │       │   ├── PatientController.java
│   │   │       │   └── UserController.java
│   │   │       │
│   │   │       ├── 📁 dto
│   │   │       │   ├── 📁 request
│   │   │       │   └── 📁 response
│   │   │       │
│   │   │       ├── 📁 entity
│   │   │       │   ├── Appointment.java
│   │   │       │   ├── Department.java
│   │   │       │   ├── Doctor.java
│   │   │       │   ├── Patient.java
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── 📁 exception
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       │
│   │   │       ├── 📁 repository
│   │   │       │   ├── AppointmentRepository.java
│   │   │       │   ├── DepartmentRepository.java
│   │   │       │   ├── DoctorRepository.java
│   │   │       │   ├── PatientRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       │
│   │   │       ├── 📁 security
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   └── JwtService.java
│   │   │       │
│   │   │       └── 📁 service
│   │   │           ├── AppointmentService.java
│   │   │           ├── AuthService.java
│   │   │           ├── DepartmentService.java
│   │   │           ├── DoctorService.java
│   │   │           ├── PatientService.java
│   │   │           ├── UserService.java
│   │   │           └── 📁 impl
│   │   │
│   │   └── 📁 resources
│   │       └── application.properties
│   │
│   └── 📁 test
│
├── 📄 pom.xml
├── 📄 mvnw
├── 📄 mvnw.cmd
├── 📄 .gitignore
└── 📄 README.md
```

---

# 🔐 Authentication Flow

The application uses **JWT-based authentication**.

```text
             👤 Client
                │
                │ Login
                ▼
        ┌──────────────────┐
        │  AuthController  │
        └────────┬─────────┘
                 │
                 ▼
        ┌──────────────────┐
        │   AuthService    │
        └────────┬─────────┘
                 │
                 ▼
        ┌──────────────────┐
        │ UserRepository   │
        └────────┬─────────┘
                 │
                 ▼
             🗄️ MySQL
                 │
                 ▼
          Validate User
                 │
                 ▼
             Generate
               JWT
                 │
                 ▼
          🎫 Return Token
```

The client then sends the token with protected requests:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

# 🛡️ Authorization Flow

After receiving a request containing a JWT:

```text
🌐 Client
   │
   │ Authorization: Bearer <JWT>
   ▼
🔐 JwtAuthenticationFilter
   │
   ▼
🎫 Validate JWT
   │
   ▼
👤 Extract User Role
   │
   ▼
🛡️ Spring Security
   │
   ▼
🔎 Check Authorization
   │
   ├───────────────┐
   │               │
   ▼               ▼
Allowed          Forbidden
   │               │
   ▼               ▼
Controller      403 Forbidden
```

### HTTP Security Responses

| Status             | Meaning                                    |
| ------------------ | ------------------------------------------ |
| `200 OK`           | Request successfully processed             |
| `201 Created`      | Resource successfully created              |
| `400 Bad Request`  | Invalid request / validation failure       |
| `401 Unauthorized` | Missing or invalid authentication          |
| `403 Forbidden`    | Authenticated but insufficient permissions |

---

# 👥 Role-Based Authorization

The application uses roles to control access to APIs.

Example:

```text
👑 ADMIN
 │
 ├── User Management
 ├── Doctor Management
 ├── Department Management
 └── Other authorized operations

🧑 PATIENT
 │
 ├── Patient operations
 ├── View authorized doctors
 ├── View authorized departments
 └── Appointment operations
```

A valid JWT alone does not automatically grant access to every API. The user's role is also checked.

---

# 👤 User Management Flow

```text
Client
  │
  ▼
UserController
  │
  ▼
UserService
  │
  ▼
UserRepository
  │
  ▼
MySQL
```

User information includes:

* ID
* Name
* Email
* Password
* Phone number
* Role
* Active status

---

# 🧑‍⚕️ Doctor Management

The Doctor module manages doctor information.

```text
Client
  │
  ▼
DoctorController
  │
  ▼
DoctorService
  │
  ▼
DoctorRepository
  │
  ▼
MySQL
```

---

# 🧑‍🦽 Patient Management

The Patient module manages patient information such as:

* Name
* Email
* Phone number
* Date of birth
* Gender
* Blood group
* Address

Flow:

```text
Client
  │
  ▼
PatientController
  │
  ▼
PatientService
  │
  ▼
PatientRepository
  │
  ▼
MySQL
```

---

# 🏥 Department Management

The Department module manages hospital departments.

Examples:

```text
❤️ Cardiology
🦴 Orthopedics
🧠 Neurology
🩺 General Medicine
```

Flow:

```text
Client
  │
  ▼
DepartmentController
  │
  ▼
DepartmentService
  │
  ▼
DepartmentRepository
  │
  ▼
MySQL
```

---

# 📅 Appointment Management

Appointments connect patients, doctors, and departments using their respective IDs.

Example:

```text
Patient
   │
   │ patientId
   ▼
Appointment
   ▲
   │ doctorId
   │
Doctor

Appointment
   │
   │ departmentId
   ▼
Department
```

An appointment contains:

```text
Appointment ID
Patient ID
Doctor ID
Department ID
Appointment Date
Appointment Time
Reason
Status
Created At
Updated At
```

### Appointment Flow

```text
             🌐 Client
                 │
                 ▼
       AppointmentController
                 │
                 ▼
        AppointmentService
                 │
        ┌────────┼────────┐
        ▼        ▼        ▼
     Patient   Doctor  Department
      Data      Data      Data
        │        │        │
        └────────┼────────┘
                 ▼
       AppointmentRepository
                 │
                 ▼
               MySQL
```

---

# ✅ Validation

Incoming requests are validated before being processed.

For example, if required fields are missing:

```json
{
  "error": "Validation Failed",
  "status": 400
}
```

This prevents invalid data from reaching the business layer.

---

# ⚠️ Exception Handling

The project contains a centralized exception handling mechanism.

```text
Controller
    ↓
Service
    ↓
Exception
    ↓
GlobalExceptionHandler
    ↓
Standard API Response
```

This provides consistent error responses across the application.

---

# 📄 DTO Architecture

The application uses separate DTOs for requests and responses.

```text
Client
  │
  ▼
Request DTO
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Entity
  │
  ▼
Repository
  │
  ▼
Database
  │
  ▼
Response DTO
  │
  ▼
Client
```

This keeps API models separate from database entities.

---

# 📑 Pagination

List APIs support pagination.

Example:

```http
GET /hospital/users?page=0&size=20
```

Example response:

```json
{
  "content": [],
  "page": 0,
  "size": 20,
  "totalElements": 2,
  "totalPages": 1,
  "first": true,
  "last": true
}
```

---

# 📊 Standard API Response

The project uses a common API response structure.

### Success

```json
{
  "success": true,
  "message": "Users fetched successfully",
  "data": {}
}
```

### Error

```json
{
  "success": false,
  "message": "Something went wrong",
  "data": null
}
```

---

# 🧪 API Testing

APIs were tested using **Postman**.

Typical testing flow:

```text
1️⃣ Login
   ↓
2️⃣ Receive JWT
   ↓
3️⃣ Copy JWT
   ↓
4️⃣ Add Bearer Token
   ↓
5️⃣ Call protected API
   ↓
6️⃣ Verify response
```

Example:

```http
Authorization: Bearer eyJhbGciOi...
```

---

# 📚 API Documentation

Swagger / OpenAPI is configured for API documentation.

Swagger can be used to:

* 📖 View available APIs
* 🧾 View request and response models
* 🧪 Test endpoints
* 🔐 Test secured endpoints with authorization

---

# 🗄️ Database Architecture

The application uses MySQL with Spring Data JPA and Hibernate.

```text
Spring Boot
     │
     ▼
Spring Data JPA
     │
     ▼
Hibernate
     │
     ▼
JDBC
     │
     ▼
🐬 MySQL
```

Main entities:

```text
👤 User
🧑‍🦽 Patient
🧑‍⚕️ Doctor
🏥 Department
📅 Appointment
```

---

# 🚀 How to Run

### 1️⃣ Clone the repository

```bash
git clone https://github.com/swamy-sidda/spring-boot-hospital-management-system.git
```

### 2️⃣ Open the project

Open the project using:

* Spring Tool Suite
* IntelliJ IDEA
* Eclipse

### 3️⃣ Configure MySQL

Create the required database and update:

```text
src/main/resources/application.properties
```

with your local database configuration.

### 4️⃣ Build the project

```bash
mvn clean install
```

or on Windows:

```cmd
mvnw.cmd clean install
```

### 5️⃣ Run the application

Run:

```text
HospitalmanagerApplication.java
```

---

# 🔄 Complete Application Flow

The complete request lifecycle can be represented as:

```text
                    🌐 CLIENT
                       │
                       ▼
                HTTP REQUEST
                       │
                       ▼
              🔐 SPRING SECURITY
                       │
                       ▼
             🎫 JWT AUTHENTICATION
                       │
                       ▼
             🛡️ ROLE AUTHORIZATION
                       │
                       ▼
                🎯 CONTROLLER
                       │
                       ▼
                 📦 DTO VALIDATION
                       │
                       ▼
                 ⚙️ SERVICE
                       │
                       ▼
                🗃️ REPOSITORY
                       │
                       ▼
                  🐬 MYSQL
                       │
                       ▼
                 DATABASE
                  RESPONSE
                       │
                       ▼
                🗃️ REPOSITORY
                       │
                       ▼
                  ⚙️ SERVICE
                       │
                       ▼
               📦 RESPONSE DTO
                       │
                       ▼
                🌐 API RESPONSE
                       │
                       ▼
                    CLIENT
```

---

# 🎯 Learning Objectives

This project was developed to practice:

* ☕ Java
* 🌱 Spring Boot
* 🌐 REST API development
* 🧩 Layered architecture
* 🗄️ JPA and Hibernate
* 🐬 MySQL
* 📦 DTO design
* ✅ Validation
* ⚠️ Exception handling
* 📑 Pagination
* 🔐 Spring Security
* 🎫 JWT authentication
* 🛡️ Role-based authorization
* 📚 Swagger / OpenAPI
* 🧪 Postman API testing
* 📦 Maven
* 🔧 Git
* 🐙 GitHub

---

# 🔮 Future Enhancements

Possible future improvements:

* 📋 Medical records
* 💊 Prescription management
* 📎 File/document management
* 📧 Email notifications
* ⏰ Appointment reminders
* 🔎 Advanced search and filtering
* 🧪 Unit and integration testing
* 🌐 Microservices architecture
* 🚪 API Gateway
* 🔎 Service Discovery
* 📨 Kafka / event-driven communication

---

# 👨‍💻 Author

### Swamy Siddarapu

💻 Java | Spring Boot | REST APIs | SQL

🔗 GitHub:
https://github.com/swamy-sidda

---

<p align="center">
  ⭐ If you find this project useful, consider giving it a star!
</p>

<p align="center">
  <b>Built with Java & Spring Boot 🚀</b>
</p>
