package br.com.aluraAPI.aluraAPI.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationInfoDTO(

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {
}
