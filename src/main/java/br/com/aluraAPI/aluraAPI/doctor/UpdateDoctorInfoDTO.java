package br.com.aluraAPI.aluraAPI.doctor;

import br.com.aluraAPI.aluraAPI.address.AddressDTO;
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