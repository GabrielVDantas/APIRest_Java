package br.com.aluraAPI.aluraAPI.entity.doctor;

import br.com.aluraAPI.aluraAPI.entity.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "doctors")
@Entity(name = "Doctor")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active;

    public Doctor(RegisterDoctorDTO registerDoctorDTO) {
        this.name = registerDoctorDTO.name();
        this.email = registerDoctorDTO.email();
        this.phone = registerDoctorDTO.phone();
        this.crm = registerDoctorDTO.crm();
        this.specialty = registerDoctorDTO.specialty();
        this.address = new Address(registerDoctorDTO.addressDTO());
        this.active = true;
    }

    public void updateDoctorInformation(UpdateDoctorInfoDTO updateDoctorInfoDTO) {
        if (updateDoctorInfoDTO != null) {
            this.name = updateDoctorInfoDTO.name();
        }
        if (updateDoctorInfoDTO.phone() != null) {
            this.phone = updateDoctorInfoDTO.phone();
        }
        if (updateDoctorInfoDTO.addressDTO() != null) {
            this.address.updateAddressInformation(updateDoctorInfoDTO.addressDTO());
        }
    }

    public void inactivate(Long id) {
        this.active = false;
    }
}
