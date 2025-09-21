# DentalClinicMVC

**Dental Clinic Management System** developed with Spring Boot, implementing MVC architecture, JWT-based security, and an interactive web interface.

## 🚀 Overview

DentalClinicMVC allows you to manage users, dentists, patients, and appointments with a robust authentication system and clear separation of concerns.
It is designed following development best practices, with well-defined layers and a consistent data flow.

## 📦 Project Structure

### 1. Authentication Layer (`authentication/`)

* `AuthenticationController`: Handles login and registration.
* `AuthenticationService`: Authentication logic.
* DTOs: `AuthenticationRequest/Response`, `RegisterRequest`.

### 2. Security Configuration (`configuration/`)

* `SecurityConfiguration`: Security rules.
* `JwtAuthenticationFilter`: Validates JWT in requests.
* `JwtService`: Generates and validates tokens.
* `ApplicationConfig`: General configuration.

### 3. Controllers (`controller/`)

* `AppointmentController`, `DentistController`, `PatientController`.

### 4. Entities (`entity/`)

* `User`, `Role`, `Dentist`, `Patient`, `Appointment`, `Address`.

### 5. Repositories (`repository/`)

* Extend `JpaRepository`: `IUserRepository`, `IDentistRepository`, `IPatientRepository`, `IAppointmentRepository`.

### 6. Services (`service/`)

* Interfaces: `IUserService`, `IDentistService`, `IPatientService`, `IAppointmentService`.
* Implementations (`impl/`): `DentistServiceImpl`, `PatientService`, `AppointmentService`.

### 7. Frontend (`resources/static/`)

* HTML: `index.html`, `login.html`, `register.html`, `dentistList.html`, `dentistAdd.html`.
* JS: `delete_dentist.js`, `get_dentist.js`, `post_dentist.js`, `update_dentist.js`.

### 8. Exception Handling (`exception/`)

* `GlobalException`, `ResourceNotFoundException`.

### 9. DTOs (`dto/`)

* `AppointmentDTO`.

### 10. Tests (`test/`)

* Unit tests for services and business logic.

## 🔗 Entity Relationships

* `User` ↔ `Role` (enumeration)
* `Dentist` ↔ `Appointment` (One-to-Many)
* `Patient` ↔ `Address` (One-to-One)
* `Patient` ↔ `Appointment` (One-to-Many)
* `Appointment` ↔ `Patient` / `Dentist` (Many-to-One)

## 🛠 Key Features

* JWT-based authentication and authorization.
* Full CRUD for dentists, patients, and appointments.
* Dynamic web interface with HTML and JavaScript.
* Global exception handling.
* Layered architecture and SOLID principles.
* Security powered by Spring Security.

## 🌐 Application Flow

1. The user authenticates via JWT.
2. Gains access to features based on their role.
3. Frontend and backend communicate through REST APIs.
4. Services handle business logic.
5. Repositories interact with the database.
6. The response is returned to the frontend.

## 💡 Highlights and Differentiators

* Advanced security with JWT integration.
* Clear separation of concerns across layers.
* Consistent and maintainable data flow.
* Solid foundation for adding new features and microservices.

## 🏁 Getting Started

1. Clone the repository.
2. Configure the database in `application.properties`.
3. Run `mvn spring-boot:run`.
4. Access the app at `http://localhost:8080`.

## 📚 Future Improvements

* Swagger implementation for automatic API documentation.
* Email notifications for appointments.
* Metrics dashboard and admin statistics.

---
