package com.sistema_autenticacao.PROJETO.SISTEMA.DE.AUTENTICACAO.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {


    @NotBlank(message = "Nome é Obrigatório")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @NotBlank(message = "Senha deve ter no mínimo 6 Dígitos")
    private String password;

}
