package br.com.aluraAPI.aluraAPI.entity.patient;

public record ListPatientDTO(

        String name,

        String email,

        String cpf
) {
    public ListPatientDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
