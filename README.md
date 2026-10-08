# 🚀 SmartHire

> [!IMPORTANT]
> ### Testing Protected APIs
>
> Most APIs in SmartHire are secured using JWT authentication.
>
> Before testing protected endpoints:
>
> 1. Open the **Swagger UI**.
> 2. Select **Auth Service** from the service dropdown.
> 3. Call **POST `/api/login`** to generate a JWT.
> 4. Copy the JWT from the response.
> 5. Click the **Authorize (🔒)** button.
> 6. Paste the JWT into the authorization field.
> 7. Click **Authorize**.
> 8. Switch to any microservice and test protected endpoints.

---

## **An AI-Powered Job Portal Backend built using Java, Spring Boot Microservices, Spring Cloud, Apache Kafka, Google Gemini AI, MySQL, MongoDB, Swagger / OpenAPI, Log4j2 and Maven.**

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-Microservices-success?style=for-the-badge)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success?style=for-the-badge)
![Kafka](https://img.shields.io/badge/Apache-Kafka-black?style=for-the-badge&logo=apachekafka)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql)
![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-47A248?style=for-the-badge&logo=mongodb)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-blue?style=for-the-badge)

</p>

---

# 📖 Overview

SmartHire is a backend-only Job Portal built using a **Microservices Architecture** with **Spring Boot** and **Spring Cloud**.

The project demonstrates:

- Secure JWT Authentication
- Role-Based Access Control (RBAC)
- Spring Cloud API Gateway
- Eureka Service Discovery
- OpenFeign Inter-Service Communication
- Apache Kafka Event-Driven Architecture
- AI-powered Candidate Screening using Google Gemini
- MySQL & MongoDB Integration
- Swagger / OpenAPI centralized documentation
- Structured Log4j2 logging

---

# ✨ Features

- 🔐 JWT Authentication & Authorization
- 👥 Role-Based Access Control (ADMIN, RECRUITER, CANDIDATE)
- 🏗️ Spring Boot Microservices Architecture
- 🌐 Spring Cloud API Gateway
- 🔍 Eureka Service Discovery
- 🔄 OpenFeign Inter-Service Communication
- ⚡ Apache Kafka Event Streaming
- 🤖 AI Resume Screening using Google Gemini
- 📄 Resume Management
- 🔔 Notification Service
- 🗄️ MySQL & MongoDB Integration
- 📊 Search, Pagination & Sorting APIs
- 📑 Swagger / OpenAPI Documentation
- 📝 Log4j2 Logging

---

# 🏛️ Architecture

```text
                                 Client
                                    │
                                    ▼
                           API Gateway (8085)
                        JWT Validation & Routing
                                    │
      ┌──────────────┬──────────────┼──────────────┬──────────────┐
      ▼              ▼              ▼              ▼              ▼
 Auth Service    Job Service   Candidate     AI Screening   Notification
    (8081)         (8082)        Service         Service        Service
                                  (8083)         (8084)         (8086)
                                     │
                                     ▼
                               Apache Kafka
                                     │
                                     ▼
                         Eureka Discovery Server
                                     │
                     MySQL                      MongoDB
```

---

# 🧩 Microservices

| Service | Port | Database | Responsibility |
|---------|------|----------|----------------|
| **Discovery Server** | 8761 | — | Eureka Service Registry |
| **API Gateway** | 8085 | — | Central Routing, JWT Validation & RBAC |
| **Auth Service** | 8081 | MySQL | User Registration, Login & JWT Generation |
| **Job Service** | 8082 | MySQL | Job Management, Filtering, Search & Sorting |
| **Candidate Service** | 8083 | MySQL & MongoDB | Candidate Profile & Resume Management, Application Submission |
| **AI Screening Service** | 8084 | MongoDB | AI Resume Screening using Google Gemini |
| **Notification Service** | 8086 | MongoDB | Kafka Event-Driven Notifications |

---

# 🛠️ Technology Stack

| Category | Technologies |
|-----------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3.5.x |
| Microservices | Spring Cloud (Eureka, Gateway, OpenFeign) |
| Security | Spring Security, JWT (io.jsonwebtoken) |
| AI | Spring AI, Google Gemini 2.5 Flash |
| Messaging | Apache Kafka |
| Service Communication | OpenFeign |
| Databases | MySQL (Relational), MongoDB (Document) |
| Documentation | Swagger / OpenAPI (springdoc-openapi) |
| Logging | Log4j2 |
| Build Tool | Maven |

---

# 📂 Project Structure

```text
SmartHire
│
├── discovery-server
├── api-gateway
├── auth-service
├── job-service
├── candidate-service
├── AI-screening-service
├── notification-service
└── mysql
    └── init.sql
```

---

# 📌 Core Workflow

```text
               Client
                  │
                  ▼
             API Gateway
                  │
      ┌───────────┼────────────┐
      ▼           ▼            ▼
 Auth Service  Job Service  Candidate Service
                                 │
                                 ▼
                       AI Screening Service
                                 │
                                 ▼
                      Notification Service

     Service Discovery → Eureka

     Async Communication → Apache Kafka

     Databases → MySQL & MongoDB
```

---

# 🔐 Authentication Flow

```text
                 Login Request
                       │
                       ▼
             Authentication Service
                       │
               Validate Credentials
                       │
                       ▼
                Generate JWT Token
                       │
                       ▼
                 Return JWT Token
                       │
────────────────────────────────────────────
         Every Protected API Request
────────────────────────────────────────────
                       │
                       ▼
                  API Gateway
                       │
                Validate JWT Token
                       │
          Extract User ID & Role Claims
                       │
                 Authorize Request
                       │
                       ▼
          Forward Request to Service
```

---

# ⚡ Kafka Event Flow

## Candidate Application

```text
Candidate
    │
    ▼
POST /api/candidate/apply
    │
    ▼
Candidate Service
    │
    ▼
Kafka Topic : arshdeep
    │
    ├──────────────► AI Screening Service
    │                       │
    │                       ▼
    │              Gemini AI Screening
    │                       │
    │                       ▼
    │         Kafka Topic : screening-completed
    │
    ▼
Notification Service
    │
    ▼
Application Notification Created
```

## AI Screening Completed

```text
AI Screening Service
        │
        ▼
screening-completed Topic
        │
        ▼
Notification Service
        │
        ▼
Screening Completion Notification Created
```

---

# 🌐 API Access & Swagger

| Service | Endpoint |
|---------|----------|
| Gateway UI | `http://localhost:8085/swagger-ui.html` |
| Auth Service Docs | `http://localhost:8085/auth/v3/api-docs` |
| Job Service Docs | `http://localhost:8085/jobs/v3/api-docs` |
| Candidate Service Docs | `http://localhost:8085/candidate/v3/api-docs` |
| AI Screening Service Docs | `http://localhost:8085/screening/v3/api-docs` |
| Notification Service Docs | `http://localhost:8085/notification/v3/api-docs` |

> **Note**
>
> Protected APIs require a valid JWT.
>
> Authenticate using:
>
> ```
> POST /api/login
> ```
>
> Then include:
>
> ```
> Authorization: Bearer <JWT_TOKEN>
> ```

---

# 🚀 Running the Project Locally with Maven

### 1. Prerequisites

- **Java 21 (JDK 21)**
- **Maven 3.9+** (or use included Maven Wrapper `./mvnw`)
- **MySQL Server** (running on port `3306`)
- **MongoDB Server** (running on port `27017`)
- **Apache Kafka & Zookeeper** (running on port `9092` / `2181`)
- **Google Gemini API Key** (set as environment variable `GEMINI_API_KEY`)

### 2. Database Initialization

Execute the database script located at `mysql/init.sql` on your MySQL server:

```sql
CREATE DATABASE IF NOT EXISTS smarthire_auth;
CREATE DATABASE IF NOT EXISTS smarthire_jobs;
CREATE DATABASE IF NOT EXISTS smarthire_candidates;
```

### 3. Build All Services

From the root directory or inside each microservice directory:

```bash
# Discovery Server
cd discovery-server && ./mvnw clean package -DskipTests=false
cd ..

# API Gateway
cd Api-Gateway && ./mvnw clean package
cd ..

# Auth Service
cd auth-service && ./mvnw clean package
cd ..

# Job Service
cd job-service && ./mvnw clean package
cd ..

# Candidate Service
cd candidate-service && ./mvnw clean package
cd ..

# AI Screening Service
cd AI-screening-service && ./mvnw clean package
cd ..

# Notification Service
cd notification-service && ./mvnw clean package
cd ..
```

### 4. Start Microservices in Order

Start each service using Maven:

1. **Discovery Server (Port 8761):**
   ```bash
   cd discovery-server
   ./mvnw spring-boot:run
   ```

2. **Auth Service (Port 8081):**
   ```bash
   cd auth-service
   ./mvnw spring-boot:run
   ```

3. **Job Service (Port 8082):**
   ```bash
   cd job-service
   ./mvnw spring-boot:run
   ```

4. **Candidate Service (Port 8083):**
   ```bash
   cd candidate-service
   ./mvnw spring-boot:run
   ```

5. **AI Screening Service (Port 8084):**
   ```bash
   cd AI-screening-service
   export GEMINI_API_KEY="your-gemini-api-key"   # On Windows PowerShell: $env:GEMINI_API_KEY="your-gemini-api-key"
   ./mvnw spring-boot:run
   ```

6. **Notification Service (Port 8086):**
   ```bash
   cd notification-service
   ./mvnw spring-boot:run
   ```

7. **API Gateway (Port 8085):**
   ```bash
   cd Api-Gateway
   ./mvnw spring-boot:run
   ```

---

# 📚 REST API Reference

<details>

<summary><b>🔐 Auth Service (8081)</b></summary>

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| POST | `/api/register` | Register User | Public |
| POST | `/api/login` | Login & Generate JWT | Public |

</details>

---

<details>

<summary><b>💼 Job Service (8082)</b></summary>

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| GET | `/jobs/jobs/all` | Get All Jobs | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/job/{id}` | Get Job by ID | ADMIN, RECRUITER, CANDIDATE |
| POST | `/jobs/job/add` | Create Job | ADMIN, RECRUITER |
| PUT | `/jobs/job/update/{id}` | Update Job | ADMIN, RECRUITER |
| DELETE | `/jobs/job/delete/{id}` | Delete Job | ADMIN |
| PATCH | `/jobs/job/{id}/activate` | Activate Job | ADMIN, RECRUITER |
| PATCH | `/jobs/job/{id}/deactivate` | Deactivate Job | ADMIN, RECRUITER |
| GET | `/jobs/search?keyword=` | Search Jobs | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/location/{location}` | Search by Location | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/company/{company}` | Search by Company | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/salary?minSalary=&maxSalary=` | Search by Salary | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/type/{jobType}` | Search by Job Type | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/experience/{experience}` | Search by Experience | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/active` | Active Jobs | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/page?page=&size=` | Pagination | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/sort/salary` | Sort by Salary | ADMIN, RECRUITER, CANDIDATE |
| GET | `/jobs/sort/date` | Sort by Posted Date | ADMIN, RECRUITER, CANDIDATE |

</details>

---

<details>

<summary><b>👤 Candidate Service (8083)</b></summary>

### Candidate APIs

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| GET | `/api/candidates/all` | Get All Candidates | ADMIN |
| GET | `/api/candidate/{id}` | Get Candidate by ID | ADMIN, RECRUITER, CANDIDATE |
| POST | `/api/candidate/add` | Register Candidate | ADMIN, CANDIDATE |
| PUT | `/api/candidate/update/{id}` | Update Candidate | ADMIN, CANDIDATE |
| DELETE | `/api/candidate/delete/{id}` | Delete Candidate | ADMIN |
| PATCH | `/api/candidate/{id}/activate` | Activate Candidate | ADMIN |
| PATCH | `/api/candidate/{id}/deactivate` | Deactivate Candidate | ADMIN |
| PATCH | `/api/candidate/{id}/hire` | Mark Candidate as Hired | ADMIN, RECRUITER |
| GET | `/api/candidate/search?keyword=` | Search Candidates | ADMIN, RECRUITER |
| GET | `/api/candidate/skill/{skill}` | Search by Skill | ADMIN, RECRUITER |
| GET | `/api/candidate/location/{location}` | Search by Location | ADMIN, RECRUITER |
| GET | `/api/candidate/experience/{experience}` | Search by Experience | ADMIN, RECRUITER |
| GET | `/api/candidate/status/{status}` | Search by Status | ADMIN |
| GET | `/api/candidate/page?page=&size=` | Pagination | ADMIN |
| GET | `/api/candidate/sort/date` | Sort by Registration Date | ADMIN |
| POST | `/api/candidate/apply?candidateId=&jobId=` | Apply for Job (Publishes Kafka Event) | CANDIDATE |

---

### Resume APIs

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| POST | `/resumes` | Upload Resume | ADMIN, CANDIDATE |
| GET | `/resumes/candidate/{candidateId}` | Get Resume | ADMIN, RECRUITER, CANDIDATE |
| PUT | `/resumes/candidate/{candidateId}` | Update Resume | ADMIN, CANDIDATE |
| DELETE | `/resumes/candidate/{candidateId}` | Delete Resume | ADMIN, CANDIDATE |

</details>

---

<details>

<summary><b>🤖 AI Screening Service (8084)</b></summary>

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| POST | `/api/screening/screen?candidateId=&jobId=` | Screen Candidate using Gemini AI | ADMIN, RECRUITER |
| GET | `/api/screening/all` | Get All Screening Results | ADMIN |
| GET | `/api/screening/{id}` | Get Screening by ID | ADMIN, RECRUITER |
| GET | `/api/screening/candidate/{candidateId}` | Get Candidate Screenings | ADMIN |
| GET | `/api/screening/job/{jobId}` | Get Job Screenings | ADMIN, RECRUITER |
| GET | `/api/screening/candidate/{candidateId}/job/{jobId}` | Candidate + Job Screening | ADMIN, RECRUITER |
| DELETE | `/api/screening/{id}` | Delete Screening | ADMIN |

</details>

---

<details>

<summary><b>🔔 Notification Service (8086)</b></summary>

| Method | Endpoint | Description | Access |
|---------|----------|-------------|--------|
| POST | `/api/notification/add` | Internal Notification Creation | Internal |
| GET | `/api/notification/all` | Get All Notifications | ADMIN |
| GET | `/api/notification/{id}` | Get Notification by ID | ADMIN |
| GET | `/api/notification/candidate/{candidateId}` | Candidate Notifications | ADMIN, CANDIDATE |
| GET | `/api/notification/job/{jobId}` | Job Notifications | ADMIN, RECRUITER |
| GET | `/api/notification/unread` | All Unread Notifications | ADMIN |
| GET | `/api/notification/unread/candidate/{candidateId}` | Candidate Unread Notifications | ADMIN, CANDIDATE |
| GET | `/api/notification/unread/job/{jobId}` | Job Unread Notifications | ADMIN, RECRUITER |
| PATCH | `/api/notification/{id}/read` | Mark Notification as Read | ADMIN, RECRUITER, CANDIDATE |
| DELETE | `/api/notification/{id}` | Delete Notification | ADMIN |

</details>

---

<details>

<summary><b>🌐 API Gateway (8085)</b></summary>

### Public Endpoints

| Method | Endpoint |
|---------|----------|
| POST | `/api/register` |
| POST | `/api/login` |

### Protected Routes

- `/jobs/**`
- `/api/candidate/**`
- `/api/candidates/**`
- `/resumes/**`
- `/api/screening/**`
- `/api/notification/**`

JWT Authentication and Role-Based Access Control (RBAC) are enforced at the API Gateway before requests are forwarded to downstream services.

</details>

---

# 🗄️ Databases

| Database | Purpose |
|----------|---------|
| **MySQL** | Stores Users, Jobs and Candidate Information |
| **MongoDB** | Stores Resumes, AI Screening Results and Notifications |

---

# 🔄 Event-Driven Communication

SmartHire uses **Apache Kafka** for asynchronous communication between microservices.

### Candidate Applies for Job

```text
Candidate
    │
    ▼
Candidate Service
    │
    ▼
Kafka Topic (arshdeep)
    │
    ├──────────────► AI Screening Service
    │                      │
    │                      ▼
    │              Google Gemini AI
    │                      │
    │                      ▼
    │         screening-completed Topic
    │
    ▼
Notification Service
```

### Screening Completed

```text
AI Screening Service
        │
        ▼
screening-completed Topic
        │
        ▼
Notification Service
        │
        ▼
Notification Created
```

---

# 💡 Skills Demonstrated

- Java 21
- Spring Boot
- Spring Cloud
- Spring Security
- JWT Authentication
- Role-Based Access Control (RBAC)
- API Gateway
- Eureka Service Discovery
- OpenFeign
- Apache Kafka
- Event-Driven Architecture
- Google Gemini AI
- Spring AI
- RESTful APIs
- Microservices Architecture
- MySQL
- MongoDB
- Maven
- Swagger / OpenAPI
- Log4j2
- Git
- GitHub

---

# 👨‍💻 Author

**Arshdeep Kumar**

Java Backend Developer

### Connect

- GitHub: https://github.com/Arshdeep-nayan
- LinkedIn: https://www.linkedin.com/in/arshdeep-kumar/

---

# ⭐ Project Summary

SmartHire is a production-style backend job portal built using a modern **Spring Boot Microservices Architecture**.

The project demonstrates secure JWT authentication, role-based authorization, centralized routing with Spring Cloud Gateway, service discovery using Eureka, asynchronous communication using Apache Kafka, AI-powered candidate screening with Google Gemini, and persistent multi-database architecture using MySQL and MongoDB.

The application showcases modern backend engineering practices including microservices, event-driven communication, cloud-native architecture, and RESTful API design, making it a strong portfolio project for Java Backend and Spring Boot development.

---
