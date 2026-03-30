package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.business;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.Role;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.User;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.repositorys.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String name, String email, String password) {
        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email Já cadastrado");
        }

        User user = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();

        return userRepository.saveAndFlush(user);
    }
}
