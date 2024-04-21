package br.com.aluraAPI.aluraAPI.doctor;

import br.com.aluraAPI.aluraAPI.address.AddressDTO;

public record RegisterDoctorDTO(
        String name,

        String email,

        String crm,

        Specialty specialty,

        AddressDTO addressDTO
) {

    public Doctor convertDoctorDTO(RegisterDoctorDTO registerDoctorDTO) {
        return new Doctor(registerDoctorDTO);
    }
}
