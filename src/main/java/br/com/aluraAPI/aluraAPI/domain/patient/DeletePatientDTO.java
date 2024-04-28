package br.com.aluraAPI.aluraAPI.entity.patient;

import jakarta.validation.constraints.NotNull;

public record DeletePatientDTO(

        @NotNull
        Long id
) {
}
