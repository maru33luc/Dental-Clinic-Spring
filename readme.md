# 🦷 DentalClinicMVC

Sistema de Gestión para Clínicas Dentales desarrollado con tecnologías modernas y arquitectura robusta.

## 🚀 Tecnologías Utilizadas

### Backend
- **Java 21** - Última versión LTS para máximo rendimiento y características modernas
- **Spring Boot 3.2.3** - Framework principal
  - Spring Web MVC - Para la capa web
  - Spring Data JPA - Para persistencia
  - Spring Security - Para seguridad y autenticación
  - Spring Validation - Para validación de datos
- **JWT (JSON Web Tokens)** - Autenticación stateless
- **H2 Database** - Base de datos en memoria para desarrollo
- **Lombok** - Reducción de código boilerplate
- **SpringDoc OpenAPI** - Documentación automática de API (Swagger)

### Frontend
- **HTML5** 
- **JavaScript** (Vanilla JS)
- **CSS3**
- **Thymeleaf** - Motor de plantillas

### Testing
- **JUnit 5** - Framework de testing
- **Mockito** - Framework de mocking
- **Spring Security Test** - Utilidades para testing de seguridad
- **MockMVC** - Testing de endpoints REST

### Herramientas de Desarrollo
- **Maven** - Gestión de dependencias y construcción
- **Git** - Control de versiones
- **IntelliJ IDEA/VS Code** - IDEs recomendados

## 📦 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/dh/DentalClinicMVC/
│   │       ├── authentication/          # Autenticación y JWT
│   │       │   ├── AuthenticationController.java
│   │       │   ├── AuthenticationService.java
│   │       │   ├── AuthenticationRequest.java
│   │       │   ├── AuthenticationResponse.java
│   │       │   └── RegisterRequest.java
│   │       ├── configuration/           # Configuración de Spring
│   │       │   ├── SecurityConfiguration.java
│   │       │   ├── JwtAuthenticationFilter.java
│   │       │   ├── JwtService.java
│   │       │   └── ApplicationConfig.java
│   │       ├── controller/             # Controladores REST
│   │       │   ├── AppointmentController.java
│   │       │   ├── DentistController.java
│   │       │   └── PatientController.java
│   │       ├── dto/                   # Objetos de Transferencia
│   │       │   └── AppointmentDTO.java
│   │       ├── entity/                # Entidades JPA
│   │       │   ├── User.java
│   │       │   ├── Role.java
│   │       │   ├── Dentist.java
│   │       │   ├── Patient.java
│   │       │   ├── Appointment.java
│   │       │   └── Address.java
│   │       ├── exception/             # Manejo de Excepciones
│   │       │   ├── GlobalException.java
│   │       │   └── ResourceNotFoundException.java
│   │       ├── repository/            # Repositorios JPA
│   │       │   ├── IUserRepository.java
│   │       │   ├── IDentistRepository.java
│   │       │   ├── IPatientRepository.java
│   │       │   └── IAppointmentRepository.java
│   │       └── service/               # Servicios
│   │           ├── interfaces/
│   │           │   ├── IAppointmentService.java
│   │           │   ├── IDentistService.java
│   │           │   └── IPatientService.java
│   │           └── impl/
│   │               ├── AppointmentService.java
│   │               ├── DentistServiceImpl.java
│   │               └── PatientService.java
│   └── resources/
│       ├── static/                    # Recursos Web
│       │   ├── js/
│       │   │   ├── delete_dentist.js
│       │   │   ├── get_dentist.js
│       │   │   ├── post_dentist.js
│       │   │   └── update_dentist.js
│       │   ├── index.html
│       │   ├── login.html
│       │   ├── register.html
│       │   ├── dentistList.html
│       │   └── dentistAdd.html
│       └── templates/                 # Plantillas Thymeleaf
└── test/                             # Tests
    └── java/
        └── com/dh/DentalClinicMVC/
            ├── controller/
            │   ├── AppointmentControllerTest.java
            │   ├── AuthenticationControllerTest.java
            │   ├── DentistControllerTest.java
            │   └── PatientControllerTest.java
            └── service/
                └── PatientServiceTest.java

## � Características de Seguridad

### Autenticación
- Implementación JWT completa
- Manejo de tokens en cookies seguras
- Refresh tokens
- Roles y permisos (ADMIN, USER)
- Endpoints protegidos
- Validación de datos en registro

### Seguridad Web
- CSRF deshabilitado para API REST
- Headers de seguridad configurados
- Gestión de sesiones stateless
- Configuración de CORS
- Manejo de opciones de frame (H2 Console)

## � Modelos de Datos y Relaciones

### Entidades Principales
- **User**
  - Gestión de usuarios del sistema
  - Roles y permisos
  - Autenticación

- **Dentist**
  - Información profesional
  - Registro profesional
  - Gestión de turnos

- **Patient**
  - Datos personales
  - Historia clínica
  - Dirección vinculada
  - Turnos asociados

- **Appointment**
  - Gestión de turnos
  - Relaciones con dentista y paciente
  - Fecha y hora
  - Estado del turno

### Relaciones
- `User` ↔ `Role` (Enumeración)
- `Dentist` ↔ `Appointment` (Uno a Muchos)
- `Patient` ↔ `Address` (Uno a Uno)
- `Patient` ↔ `Appointment` (Uno a Muchos)
- `Appointment` ↔ `Patient` / `Dentist` (Muchos a Uno)

## 🛠 Características Técnicas

### Patrones Implementados
- **MVC** - Separación de responsabilidades
- **DTO** - Transferencia de datos optimizada
- **Repository** - Abstracción de datos
- **Service Layer** - Lógica de negocio encapsulada
- **Builder** - Construcción de objetos complejos
- **Dependency Injection** - Acoplamiento reducido

### Testing
- Tests unitarios para servicios
- Tests de integración para controllers
- Mocking de dependencias
- Cobertura de código
- Tests de seguridad

### API REST
- CRUD completo para todas las entidades
- Validación de datos en endpoints
- Manejo de errores consistente
- Documentación con Swagger
- Respuestas HTTP apropiadas

## 🚀 Cómo Empezar

### Requisitos Previos
- Java 21 o superior
- Maven 3.6 o superior
- Git

### Configuración

1. Clonar el repositorio:
```bash
git clone https://github.com/maru33luc/Dental-Clinic-Spring.git
```

2. Configurar variable de entorno JWT:
```bash
export JWT_SECRET=tu_clave_secreta_aqui
```

3. Compilar el proyecto:
```bash
mvn clean install
```

4. Ejecutar:
```bash
mvn spring-boot:run
```

### Acceso
- **API**: http://localhost:8080
- **Swagger**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console

## 🔄 Flujo de la Aplicación

1. **Autenticación**
   - Registro de usuario
   - Login y generación de JWT
   - Almacenamiento de token en cookie segura

2. **Gestión de Pacientes**
   - Alta de pacientes
   - Actualización de datos
   - Vinculación con dirección
   - Consulta de historial

3. **Gestión de Odontólogos**
   - Registro de profesionales
   - Gestión de disponibilidad
   - Consulta de turnos

4. **Gestión de Turnos**
   - Creación de turnos
   - Validación de disponibilidad
   - Notificaciones
   - Cancelación y reprogramación

## 👥 Contribución

1. Fork del repositorio
2. Crear branch de feature (`git checkout -b feature/NuevaCaracteristica`)
3. Commit de cambios (`git commit -am 'Agrega nueva característica'`)
4. Push al branch (`git push origin feature/NuevaCaracteristica`)
5. Crear Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para detalles

## 🌟 Características Futuras

- [ ] Integración con sistema de pagos
- [ ] Notificaciones por email
- [ ] App móvil
- [ ] Reportes y estadísticas
- [ ] Chat en tiempo real
- [ ] Integración con calendario

   * Linux / macOS:

     ```bash
     export JWT_SECRET=$(openssl rand -base64 64)
     ```
   * Windows (PowerShell):

     ```powershell
     setx JWT_SECRET "your-strong-secret-key"
     ```

   The application reads this value via `@Value("${jwt.secret}")`.

4. Run `mvn spring-boot:run`.

5. Access the app at `http://localhost:8080`.

6. Explore the API docs at `http://localhost:8080/swagger-ui.html`.

## 📚 Future Improvements

* Email notifications for appointments.
* Metrics dashboard and admin statistics.

---
