package br.com.aluraAPI.aluraAPI.entity.patient;

import br.com.aluraAPI.aluraAPI.entity.address.AddressDTO;
import jakarta.persistence.Id;
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
