package br.com.aluraAPI.aluraAPI.doctor;

import br.com.aluraAPI.aluraAPI.endereco.AddressDTO;

public record RegisterDoctorDTO(
        String name,

        String email,

        String crm,

        Specialty specialty,

        AddressDTO addressDTO

) {

    public Doctor convertDoctorDTOtoDoctor(RegisterDoctorDTO registerDoctorDTO) {
        return new Doctor(registerDoctorDTO);
    }
}
