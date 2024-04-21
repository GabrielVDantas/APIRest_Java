package br.com.aluraAPI.aluraAPI.doctor;

import br.com.aluraAPI.aluraAPI.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record RegisterDoctorDTO(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        AddressDTO addressDTO
) {

    public Doctor convertDoctorDTO(RegisterDoctorDTO registerDoctorDTO) {
        return new Doctor(registerDoctorDTO);
    }
}
