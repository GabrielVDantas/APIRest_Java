package br.com.aluraAPI.aluraAPI.entity.doctor;

import br.com.aluraAPI.aluraAPI.entity.address.Address;

public record DetailedDoctorDataDTO(

        Long id,

        String name,

        String email,

        String phone,

        String crm,

        Specialty specialty,

        Address address
) {

    public DetailedDoctorDataDTO(Doctor doctor) {
        this(doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getPhone(),
            doctor.getCrm(),
            doctor.getSpecialty(),
            doctor.getAddress());
    }
}
