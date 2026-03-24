package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.business;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.Role;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.User;
import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.repositorys.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email, String password) {
        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email Já cadastrado");
        }

        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(Role.USER)
                .build();

        return userRepository.saveAndFlush(user);
    }
}
