package com.loterie.loterie.controller;

import com.loterie.loterie.entity.User;
import com.loterie.loterie.payload.request.LoginRequest;
import com.loterie.loterie.payload.request.SignupRequest;
import com.loterie.loterie.payload.response.JwtResponse;
import com.loterie.loterie.payload.response.MessageResponse;
import com.loterie.loterie.repository.UserRepository;
import com.loterie.loterie.security.jwt.JwtUtils;
import com.loterie.loterie.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return  this.userRepository.findAll();
    }




    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Créez un objet d'authentification en utilisant l'e-mail et le mot de passe
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        // Mettez à jour le contexte de sécurité avec l'objet d'authentification
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Générez le jeton JWT
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Obtenez les détails de l'utilisateur authentifié
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Retournez la réponse avec le jeton JWT et les détails de l'utilisateur
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getTel(),
                userDetails.getPassword(),
                userDetails.getRole()));
    }



    @PostMapping("/check-password")
    @ResponseBody
    public boolean validatePassword(String password, String hashedPassword) {
        password="0500";
        hashedPassword="$2a$10$12UkVFc1lbNGhcGwHUcgk.cyV8JwoFFxrNMY.mhfL0vwP.9l/JXU2";
        return passwordEncoder.matches(password, hashedPassword);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(signUpRequest.getPassword());

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getTel(),
                encodedPassword,
                signUpRequest.getRole());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}








