package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.controller;


import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.business.UserService;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto.LoginRequestDTO;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto.UserRequestDTO;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto.UserResponseDTO;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.User;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto) {
        return ResponseEntity.ok(
                userService.createUser(
                        dto.getName(),
                        dto.getEmail(),
                        dto.getPassword()));
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(userService.login(dto.getEmail(), dto.getPassword()));
    }

    @GetMapping("/me")
    public ResponseEntity<String> getUser(Authentication authentication) {
        return ResponseEntity.ok(authentication.getName());
    }
}
