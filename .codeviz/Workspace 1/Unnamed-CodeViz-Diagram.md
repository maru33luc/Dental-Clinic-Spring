# Unnamed CodeViz Diagram

```mermaid
graph TD

    subgraph 50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"]
        subgraph 50ba4caf-ARCH_Overview["**Architectural Overview**<br>Design Patterns and Application Type<br>[External]"]
            50ba4caf-ARCH_MVC["**MVC Design Pattern**<br>Model-View-Controller separation<br>[External]"]
            50ba4caf-ARCH_TYPE["**Monolithic Spring Boot Web Application**<br>Single deployment unit<br>[External]"]
        end
        subgraph 50ba4caf-BE_Tech["**Backend Technologies**<br>Server-side frameworks and tools<br>[External]"]
            50ba4caf-BE_H2["**H2 Database**<br>In-memory relational DB<br>[External]"]
            50ba4caf-BE_JWT["**JWT**<br>Stateless token-based authentication<br>[Library]"]
            50ba4caf-BE_LOMBOK["**Lombok**<br>Boilerplate code reduction<br>[Library]"]
            50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"]
            50ba4caf-BE_SPRINGDATAJPA["**Spring Data JPA**<br>Data persistence (JPA)<br>[Framework]"]
            50ba4caf-BE_SPRINGSECURITY["**Spring Security**<br>Authentication and Authorization<br>[Framework]"]
            50ba4caf-BE_SPRINGWEB["**Spring Web**<br>Web application capabilities<br>[Framework]"]
            %% Edges at this level (grouped by source)
            50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"] -->|"Integrates"| 50ba4caf-BE_SPRINGWEB["**Spring Web**<br>Web application capabilities<br>[Framework]"]
            50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"] -->|"Integrates"| 50ba4caf-BE_SPRINGDATAJPA["**Spring Data JPA**<br>Data persistence (JPA)<br>[Framework]"]
            50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"] -->|"Integrates"| 50ba4caf-BE_SPRINGSECURITY["**Spring Security**<br>Authentication and Authorization<br>[Framework]"]
            50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"] -->|"Supports"| 50ba4caf-BE_LOMBOK["**Lombok**<br>Boilerplate code reduction<br>[Library]"]
            50ba4caf-BE_SPRINGDATAJPA["**Spring Data JPA**<br>Data persistence (JPA)<br>[Framework]"] -->|"Connects to"| 50ba4caf-BE_H2["**H2 Database**<br>In-memory relational DB<br>[External]"]
            50ba4caf-BE_SPRINGSECURITY["**Spring Security**<br>Authentication and Authorization<br>[Framework]"] -->|"Uses"| 50ba4caf-BE_JWT["**JWT**<br>Stateless token-based authentication<br>[Library]"]
        end
        subgraph 50ba4caf-FE_Tech["**Frontend Technologies**<br>User interface and templating<br>[External]"]
            50ba4caf-FE_STATICASSETS["**Static Assets**<br>HTML, CSS, JavaScript files (e.g., dentistAdd.html)<br>src/main/resources/static/"]
            50ba4caf-FE_THYMELEAF["**Thymeleaf**<br>Server-side Java template engine<br>[External]"]
            %% Edges at this level (grouped by source)
            50ba4caf-FE_THYMELEAF["**Thymeleaf**<br>Server-side Java template engine<br>[External]"] -->|"Renders"| 50ba4caf-FE_STATICASSETS["**Static Assets**<br>HTML, CSS, JavaScript files (e.g., dentistAdd.html)<br>src/main/resources/static/"]
        end
        subgraph 50ba4caf-FUNC_Inferred["**Inferred Functionality**<br>Key application features<br>[External]"]
            50ba4caf-FUNC_AUTH["**User Authentication and Authorization**<br>Login, access control<br>[Feature]"]
            50ba4caf-FUNC_CRUD["**CRUD Operations**<br>Dentists, Patients, Appointments<br>[Feature]"]
        end
        subgraph 50ba4caf-SRC_Dir["**src/ Directory**<br>Application Source Code<br>src/"]
            50ba4caf-SRC_MAIN["**src/main/**<br>Main application code<br>src/main/"]
            50ba4caf-SRC_TEST["**src/test/**<br>Test code<br>src/test/"]
            subgraph 50ba4caf-SRC_MainSub["**src/main/**<br>[External]"]
                50ba4caf-SRC_JAVA["**src/main/java/**<br>Java source code<br>src/main/java/"]
                50ba4caf-SRC_RESOURCES["**src/main/resources/**<br>Application resources<br>src/main/resources/"]
                subgraph 50ba4caf-SRC_ResourcesSub["**src/main/resources/**<br>[External]"]
                    50ba4caf-SRC_STATIC["**static/**<br>Static assets (HTML, CSS, JS)<br>src/main/resources/static/"]
                    50ba4caf-SRC_TEMPLATES["**templates/**<br>Thymeleaf templates<br>src/main/resources/templates/"]
                    %% Edges at this level (grouped by source)
                    50ba4caf-SRC_ResourcesSub["**src/main/resources/**<br>[External]"] --> 50ba4caf-SRC_TEMPLATES["**templates/**<br>Thymeleaf templates<br>src/main/resources/templates/"]
                    50ba4caf-SRC_ResourcesSub["**src/main/resources/**<br>[External]"] --> 50ba4caf-SRC_STATIC["**static/**<br>Static assets (HTML, CSS, JS)<br>src/main/resources/static/"]
                end
                %% Edges at this level (grouped by source)
                50ba4caf-SRC_MainSub["**src/main/**<br>[External]"] --> 50ba4caf-SRC_JAVA["**src/main/java/**<br>Java source code<br>src/main/java/"]
                50ba4caf-SRC_MainSub["**src/main/**<br>[External]"] --> 50ba4caf-SRC_RESOURCES["**src/main/resources/**<br>Application resources<br>src/main/resources/"]
                50ba4caf-SRC_RESOURCES["**src/main/resources/**<br>Application resources<br>src/main/resources/"] --> 50ba4caf-SRC_ResourcesSub["**src/main/resources/**<br>[External]"]
            end
            %% Edges at this level (grouped by source)
            50ba4caf-SRC_Dir["**src/ Directory**<br>Application Source Code<br>src/"] --> 50ba4caf-SRC_MAIN["**src/main/**<br>Main application code<br>src/main/"]
            50ba4caf-SRC_Dir["**src/ Directory**<br>Application Source Code<br>src/"] --> 50ba4caf-SRC_TEST["**src/test/**<br>Test code<br>src/test/"]
            50ba4caf-SRC_MAIN["**src/main/**<br>Main application code<br>src/main/"] --> 50ba4caf-SRC_MainSub["**src/main/**<br>[External]"]
        end
        subgraph 50ba4caf-TL_Structure["**Top-Level Project Structure**<br>[External]"]
            50ba4caf-TL_DB["**Database Files**<br>H2 DB files (e.g., dc.mv.db)<br>.*.mv.db|.*.trace.db"]
            50ba4caf-TL_GITIGNORE["**.gitignore**<br>Git exclusion rules<br>.gitignore"]
            50ba4caf-TL_HELP["**HELP.md**<br>Project documentation<br>HELP.md"]
            50ba4caf-TL_IDEA["**.idea/**<br>IntelliJ IDEA configurations<br>.idea/"]
            50ba4caf-TL_MVNW["**mvnw**<br>Maven Wrapper (Unix)<br>mvnw"]
            50ba4caf-TL_MVNWCMD["**mvnw.cmd**<br>Maven Wrapper (Windows)<br>mvnw.cmd"]
            50ba4caf-TL_POM["**pom.xml**<br>Maven Project Object Model<br>pom.xml"]
            50ba4caf-TL_TARGET["**target/**<br>Build artifacts<br>target/"]
        end
        %% Edges at this level (grouped by source)
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-TL_Structure["**Top-Level Project Structure**<br>[External]"]
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-SRC_Dir["**src/ Directory**<br>Application Source Code<br>src/"]
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-ARCH_Overview["**Architectural Overview**<br>Design Patterns and Application Type<br>[External]"]
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-BE_Tech["**Backend Technologies**<br>Server-side frameworks and tools<br>[External]"]
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-FE_Tech["**Frontend Technologies**<br>User interface and templating<br>[External]"]
        50ba4caf-DentalClinicMVC_Root["**DentalClinicMVC Project Structure**<br>Spring Boot Web Application<br>[External]"] --> 50ba4caf-FUNC_Inferred["**Inferred Functionality**<br>Key application features<br>[External]"]
        50ba4caf-ARCH_TYPE["**Monolithic Spring Boot Web Application**<br>Single deployment unit<br>[External]"] -->|"Uses"| 50ba4caf-BE_SPRINGBOOT["**Spring Boot**<br>Foundational framework<br>[Framework]"]
        50ba4caf-ARCH_MVC["**MVC Design Pattern**<br>Model-View-Controller separation<br>[External]"] -->|"Implemented via"| 50ba4caf-BE_SPRINGWEB["**Spring Web**<br>Web application capabilities<br>[Framework]"]
        50ba4caf-ARCH_MVC["**MVC Design Pattern**<br>Model-View-Controller separation<br>[External]"] -->|"Implemented via"| 50ba4caf-FE_THYMELEAF["**Thymeleaf**<br>Server-side Java template engine<br>[External]"]
        50ba4caf-FUNC_CRUD["**CRUD Operations**<br>Dentists, Patients, Appointments<br>[Feature]"] -->|"Managed by"| 50ba4caf-BE_SPRINGDATAJPA["**Spring Data JPA**<br>Data persistence (JPA)<br>[Framework]"]
        50ba4caf-FUNC_CRUD["**CRUD Operations**<br>Dentists, Patients, Appointments<br>[Feature]"] -->|"Exposed via"| 50ba4caf-BE_SPRINGWEB["**Spring Web**<br>Web application capabilities<br>[Framework]"]
        50ba4caf-FUNC_CRUD["**CRUD Operations**<br>Dentists, Patients, Appointments<br>[Feature]"] -->|"Displayed with"| 50ba4caf-FE_THYMELEAF["**Thymeleaf**<br>Server-side Java template engine<br>[External]"]
        50ba4caf-FUNC_AUTH["**User Authentication and Authorization**<br>Login, access control<br>[Feature]"] -->|"Implemented by"| 50ba4caf-BE_SPRINGSECURITY["**Spring Security**<br>Authentication and Authorization<br>[Framework]"]
        50ba4caf-FUNC_AUTH["**User Authentication and Authorization**<br>Login, access control<br>[Feature]"] -->|"Uses"| 50ba4caf-BE_JWT["**JWT**<br>Stateless token-based authentication<br>[Library]"]
        50ba4caf-FUNC_AUTH["**User Authentication and Authorization**<br>Login, access control<br>[Feature]"] -->|"Displayed with"| 50ba4caf-FE_STATICASSETS["**Static Assets**<br>HTML, CSS, JavaScript files (e.g., dentistAdd.html)<br>src/main/resources/static/"]
    end

```
---
*Generated by [CodeViz.ai](https://codeviz.ai) on 20/9/2025, 21:19:55*
