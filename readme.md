# DentalClinicMVC

**Sistema de gestión para clínicas dentales** desarrollado con Spring Boot, implementando arquitectura MVC, seguridad basada en JWT y una interfaz web interactiva.

## 🚀 Descripción General

DentalClinicMVC permite gestionar usuarios, odontólogos, pacientes y citas, con un sistema de autenticación robusto y una separación clara de responsabilidades. Está diseñado siguiendo buenas prácticas de desarrollo, con capas bien definidas y flujo de datos consistente.

## 📦 Estructura del Proyecto

### 1. Capa de Autenticación (`authentication/`)

* `AuthenticationController`: Login y registro.
* `AuthenticationService`: Lógica de autenticación.
* DTOs: `AuthenticationRequest/Response`, `RegisterRequest`.

### 2. Configuración de Seguridad (`configuration/`)

* `SecurityConfiguration`: Reglas de seguridad.
* `JwtAuthenticationFilter`: Valida JWT en requests.
* `JwtService`: Genera y valida tokens.
* `ApplicationConfig`: Configuración general.

### 3. Controladores (`controller/`)

* `AppointmentController`, `DentistController`, `PatientController`.

### 4. Entidades (`entity/`)

* `User`, `Role`, `Dentist`, `Patient`, `Appointment`, `Address`.

### 5. Repositorios (`repository/`)

* Extienden de `JpaRepository`: `IUserRepository`, `IDentistRepository`, `IPatientRepository`, `IAppointmentRepository`.

### 6. Servicios (`service/`)

* Interfaces: `IUserService`, `IDentistService`, `IPatientService`, `IAppointmentService`.
* Implementaciones (`impl/`): `DentistServiceImpl`, `PatientService`, `AppointmentService`.

### 7. Frontend (`resources/static/`)

* HTML: `index.html`, `login.html`, `register.html`, `dentistList.html`, `dentistAdd.html`.
* JS: `delete_dentist.js`, `get_dentist.js`, `post_dentist.js`, `update_dentist.js`.

### 8. Manejo de Excepciones (`exception/`)

* `GlobalException`, `ResourceNotFoundException`.

### 9. DTOs (`dto/`)

* `AppointmentDTO`.

### 10. Pruebas (`test/`)

* Pruebas unitarias para servicios y lógica de negocio.

## 🔗 Relaciones entre Entidades

* `User` ↔ `Role` (enumeración)
* `Dentist` ↔ `Appointment` (One-to-Many)
* `Patient` ↔ `Address` (One-to-One)
* `Patient` ↔ `Appointment` (One-to-Many)
* `Appointment` ↔ `Patient` / `Dentist` (Many-to-One)

## 🛠 Características Principales

* Autenticación y autorización basada en JWT.
* CRUD completo para odontólogos, pacientes y citas.
* Interfaz web dinámica con HTML y JavaScript.
* Manejo global de excepciones.
* Arquitectura en capas y principios SOLID.
* Seguridad con Spring Security.

## 🌐 Flujo de la Aplicación

1. El usuario se autentica mediante JWT.
2. Accede a las funcionalidades según su rol.
3. Frontend y backend se comunican mediante API REST.
4. Los servicios procesan la lógica de negocio.
5. Los repositorios interactúan con la base de datos.
6. La respuesta regresa al frontend.

## 💡 Novedades y Diferenciadores

* Integración de JWT con seguridad avanzada.
* Capas separadas con responsabilidades claras.
* Flujo de datos consistente y mantenible.
* Base sólida para agregar nuevas funcionalidades y microservicios.

## 🏁 Comenzando

1. Clonar el repositorio.
2. Configurar la base de datos en `application.properties`.
3. Ejecutar `mvn spring-boot:run`.
4. Acceder a la aplicación en `http://localhost:8080`.

## 📚 Futuras Mejoras

* Implementación de Swagger para documentación automática de API.
* Notificaciones por correo para citas.
* Dashboard de métricas y estadísticas para administración.

---
