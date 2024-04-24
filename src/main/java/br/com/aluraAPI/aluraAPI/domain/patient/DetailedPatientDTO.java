package br.com.aluraAPI.aluraAPI.domain.patient;

import br.com.aluraAPI.aluraAPI.domain.address.Address;

public record DetailedPatientDTO(

        Long id,

        String name,

        String email,

        String phone,

        String cpf,

        Address address
) {

    public DetailedPatientDTO(Patient patient) {
        this(patient.getId(), patient.getName(),
                patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAddress());
    }
}
