package br.com.aluraAPI.aluraAPI.domain.patient;

import br.com.aluraAPI.aluraAPI.domain.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPatientDTO(

        @NotBlank(message = "Preencha o campo Nome")
        String name,

        @NotBlank(message = "Preencha o campo Email")
        @Email
        String email,

        @NotBlank(message = "Preencha o campo Telefone")
        String phone,

        @NotBlank(message = "Preencha o campo CPF")
        String cpf,

        @NotNull
        @Valid
        AddressDTO addressDTO
) {

    public Patient convertPatientDTO(RegisterPatientDTO registerPatientDTO) {
        return new Patient(registerPatientDTO);
    }
}
