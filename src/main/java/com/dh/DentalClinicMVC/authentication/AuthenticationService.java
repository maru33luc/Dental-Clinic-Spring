package com.dh.DentalClinicMVC.authentication;

import com.dh.DentalClinicMVC.configuration.JwtService;
import com.dh.DentalClinicMVC.entity.Role;
import com.dh.DentalClinicMVC.entity.User;
import com.dh.DentalClinicMVC.repository.IUserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2) Cargar datos del usuario
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();



        // 3) Generar token y guardarlo en cookie
        var jwt = jwtService.generateTokenAndSetCookie(user, response);

        // 4) Devolver la respuesta normal para Postman o frontend JS
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();

    }
}
