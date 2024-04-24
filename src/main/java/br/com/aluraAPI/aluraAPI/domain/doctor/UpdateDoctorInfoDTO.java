package br.com.aluraAPI.aluraAPI.domain.doctor;

import br.com.aluraAPI.aluraAPI.domain.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorInfoDTO(

        @NotNull
        Long id,

        String name,

        String phone,

        @Valid
        AddressDTO addressDTO
) {
}
