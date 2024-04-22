package br.com.aluraAPI.aluraAPI.doctor;

public record ListDoctorsDTO(

        String name,

        String email,

        String crm,

        Specialty specialty
) {

    public ListDoctorsDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
