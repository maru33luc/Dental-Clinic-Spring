package com.dh.DentalClinicMVC.authentication;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @jakarta.validation.Valid RegisterRequest request) {
        if (request.getFirstname() == null || request.getLastname() == null || 
            request.getEmail() == null || request.getPassword() == null ||
            request.getFirstname().trim().isEmpty() || request.getLastname().trim().isEmpty() ||
            request.getEmail().trim().isEmpty() || request.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ) {
        try {
            // Obtenemos la respuesta de autenticación que incluye el token
            AuthenticationResponse authResponse = authenticationService.login(request, response);
            
            // Aseguramos que la cookie tenga la configuración correcta
            Cookie jwtCookie = new Cookie("jwt", authResponse.getToken());
            jwtCookie.setPath("/");
            jwtCookie.setHttpOnly(true);
            jwtCookie.setMaxAge(24 * 60 * 60); // 24 horas
            response.addCookie(jwtCookie);
            
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("Invalid credentials")) {
                return ResponseEntity.status(401).build();
            }
            throw e;
        }
    }

    @GetMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<Resource> showLoginPage() {
        Resource resource = new ClassPathResource("static/login.html");
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(resource);
    }

    @GetMapping(value = "/register", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<Resource> showRegisterPage() {
        Resource resource = new ClassPathResource("static/register.html");
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(resource);
    }



}
