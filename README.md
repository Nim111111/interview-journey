# Interview Journey – Job Application Tracker (Backend)

## Overview

Interview Journey is a full-stack Job Application Tracking System built to help job seekers organize, monitor, and manage their job application process from a single platform.

The backend exposes secure REST APIs that allow users to manage applications, monitor interview progress, and analyze application statistics. Google OAuth2 authentication ensures only authenticated users can access protected resources.

> **Current Status**
>
> Backend Completed
>
> React Frontend Currently Under Development

---

## Problem Statement

Keeping track of multiple job applications across different companies becomes difficult during an active job search.

Candidates often lose track of:

* Application status
* Interview schedules
* Company details
* Job sources
* Application history

Interview Journey solves this problem by providing a centralized platform where users can securely manage every stage of their job search.

---

## Features

### Authentication

* Google OAuth2 Login
* Spring Security authentication
* Protected REST APIs
* Custom OAuth2UserService implementation

### Application Management

* Create applications
* Update applications
* Delete applications
* View all applications
* View application by ID

### Search & Filtering

* Search by company
* Search by role
* Filter by application status

### Dashboard

* Total Applications
* Applications by Status
* Dashboard statistics

### Sorting

* Sort by company
* Sort by application date

### Pagination

* Paginated API endpoints
* Optimized database access

### Exception Handling

* Global exception handling
* Custom ResourceNotFoundException

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring MVC
* Spring Data JPA (Hibernate ORM)
* Spring Security
* OAuth2 Client

### Database

* MySQL

### Build Tool

* Maven

### API Testing

* Postman

### Documentation

* Swagger/OpenAPI

---

## Database Design

The application uses a relational MySQL database with Hibernate ORM.

Entities include:

* User
* Application

Relationships are mapped using JPA annotations.

---

## Authentication Flow

The application uses Google OAuth2 Login.

Authentication flow:

1. User clicks Sign in with Google.
2. Google authenticates the user.
3. Spring Security receives the OAuth token.
4. CustomOAuth2UserService processes the user information.
5. User details are stored/retrieved from the database.
6. Protected APIs become accessible.

---

## REST APIs

Examples:

GET /api/applications

POST /api/applications

PUT /api/applications/{id}

DELETE /api/applications/{id}

GET /api/applications/dashboard

GET /api/applications/search

GET /api/applications/paged

GET /api/applications/status/{status}

---

## Architecture

Controller

↓

Service

↓

Repository

↓

MySQL Database

Spring Security intercepts protected requests before they reach the controllers.

---

## Challenges Faced

### OAuth2 Integration

Configuring Google OAuth2 authentication with Spring Security required handling redirect URIs, client credentials, and authenticated user mapping.

### Secure API Design

Ensuring only authenticated users can access protected endpoints while allowing public authentication routes.

### Database Mapping

Designing entity relationships and implementing repository queries for filtering, pagination, and dashboard statistics.

### Exception Handling

Implemented centralized exception handling to return consistent API responses.

---

## Future Improvements

* React Frontend
* JWT Authentication
* Role-based Authorization
* Docker Containerization
* AWS Deployment
* CI/CD Pipeline using GitHub Actions
* Email Notifications
* Resume Upload
* Interview Calendar Integration

---

## Learning Outcomes

This project strengthened my understanding of:

* Spring Boot architecture
* REST API development
* Spring Security
* OAuth2 Authentication
* Hibernate ORM
* JPA Repository
* MySQL integration
* Exception handling
* Backend application architecture

---

## AI Usage

Generative AI (ChatGPT) was used as a development assistant for:

* Understanding Spring Security concepts
* Debugging OAuth2 configuration
* Designing REST API architecture
* Improving project structure
* Generating documentation
* Code review and optimization suggestions

All application architecture, implementation, debugging, testing, and integration decisions were performed and validated manually.

---

## Author

**Nimrukthi S**

Java Backend Developer | Spring Boot | React (Learning) | MySQL
