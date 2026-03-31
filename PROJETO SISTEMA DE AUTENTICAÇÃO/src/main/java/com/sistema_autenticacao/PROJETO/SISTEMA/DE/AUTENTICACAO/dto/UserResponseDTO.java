package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email) {
}
