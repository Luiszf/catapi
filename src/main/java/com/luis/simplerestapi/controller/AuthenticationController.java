package com.luis.simplerestapi.controller;

import com.luis.simplerestapi.model.user.LoginDTO;
import com.luis.simplerestapi.model.user.LoginResponseDTO;
import com.luis.simplerestapi.model.user.RegisterDTO;
import com.luis.simplerestapi.model.user.User;
import com.luis.simplerestapi.repository.UserRepository;
import com.luis.simplerestapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO data){
        var userToken = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(userToken);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO data){
        if (userRepository.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User user = new User(data.login(),encryptedPassword,data.userRole());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
