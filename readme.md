# 🦷 DentalClinicMVC

Sistema de Gestión para Clínicas Dentales desarrollado con tecnologías modernas y arquitectura robusta.

## 🚀 Tecnologías Utilizadas

### Backend

* **Java 21** - Última versión LTS para máximo rendimiento y características modernas
* **Spring Boot 3.2.3** - Framework principal

    * Spring Web MVC - Para la capa web
    * Spring Data JPA - Para persistencia
    * Spring Security - Para seguridad y autenticación
    * Spring Validation - Para validación de datos
* **JWT (JSON Web Tokens)** - Autenticación stateless
* **H2 Database** - Base de datos en memoria para desarrollo
* **Lombok** - Reducción de código boilerplate
* **SpringDoc OpenAPI** - Documentación automática de API (Swagger)

### Frontend

* **HTML5**
* **JavaScript** (Vanilla JS)
* **CSS3**
* **Thymeleaf** - Motor de plantillas

### Testing

* **JUnit 5** - Framework de testing
* **Mockito** - Framework de mocking
* **Spring Security Test** - Utilidades para testing de seguridad
* **MockMVC** - Testing de endpoints REST

### Herramientas de Desarrollo

* **Maven** - Gestión de dependencias y construcción
* **Git** - Control de versiones
* **IntelliJ IDEA/VS Code** - IDEs recomendados

## 📦 Estructura del Proyecto

```text
src/
├── main/
│   ├── java/com/dh/DentalClinicMVC/
│   │   ├── authentication/
│   │   ├── configuration/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   └── service/
│   └── resources/
└── test/
```

## 🔐 Configuración de Seguridad

La aplicación utiliza **JWT** para autenticación y autorización. **Debes generar y configurar la variable de entorno `JWT_SECRET`** antes de ejecutar el proyecto.

⚠️ **Importante:** Esta clave debe ser una cadena de **256 bits (32 bytes)** codificada en **Base64**. Ejemplo válido:

```text
sXf8qH5jYp7uL2gT1cR0aB9vE4dM3nK6zIwC7xV5oZ8qW2tY4rU1sP0k
```

### Cómo establecer `JWT_SECRET`

**Linux / macOS:**

```bash
export JWT_SECRET=$(openssl rand -base64 32)
```

**Windows (PowerShell):**

```powershell
setx JWT_SECRET "sXf8qH5jYp7uL2gT1cR0aB9vE4dM3nK6zIwC7xV5oZ8qW2tY4rU1sP0k"
```

La aplicación leerá esta variable mediante `@Value("${jwt.secret}")`.

## 🚀 Cómo Empezar

1. Clona el repositorio:

```bash
git clone https://github.com/maru33luc/Dental-Clinic-Spring.git
```

2. Configura la variable de entorno `JWT_SECRET` como se explicó arriba.
3. Compila y ejecuta:

```bash
mvn clean install && mvn spring-boot:run
```

4. Accede a:

    * **API:** [http://localhost:8080](http://localhost:8080)
    * **Swagger:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    * **H2 Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
