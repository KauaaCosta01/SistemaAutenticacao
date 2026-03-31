package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.business;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto.UserResponseDTO;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.Role;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.User;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.repositorys.UserRepository;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserResponseDTO createUser(String name, String email, String password) {
        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email Já cadastrado");
        }

        User user = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();

        User saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Senha Inválida");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
