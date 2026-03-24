package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.repositorys;

import com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
