package br.com.aluraAPI.aluraAPI.domain.patient;

import br.com.aluraAPI.aluraAPI.domain.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientInfoDTO(

        @NotNull
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String phone,

        @NotNull
        @Valid
        AddressDTO addressDTO
) {
}
