package com.example.webcalendar.services;

import com.example.webcalendar.Records.AuthRequest;
import com.example.webcalendar.Records.AuthResponse;
import com.example.webcalendar.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(AuthRequest request) {
        var user = userService.save(User.of(
                        request.username(),
                        passwordEncoder.encode(request.password()),
                        "USER")
        );
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse("Authentication success", jwtToken, user.getUsername());
    }

    public AuthResponse login(AuthRequest request) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password())
            );
        } catch (BadCredentialsException exception) {
            return new AuthResponse("Authentication fail: Invalid credentials", null, null);
        }
        var user = userService.findByName(request.username())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse("Authentication success", jwtToken, user.getUsername());
    }

    public AuthResponse getInfo(String username) {
        var user = userService.findByName(username).get();
        return new AuthResponse("User info", null, user.getUsername());
    }
}
