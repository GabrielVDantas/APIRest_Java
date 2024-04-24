package br.com.aluraAPI.aluraAPI.domain.patient;

import br.com.aluraAPI.aluraAPI.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Patient")
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String cpf;

    @Embedded
    private Address address;

    private boolean active;

    public Patient(RegisterPatientDTO registerPatientDTO) {
        this.name = registerPatientDTO.name();
        this.email = registerPatientDTO.email();
        this.phone = registerPatientDTO.phone();
        this.cpf = registerPatientDTO.cpf();
        this.address = new Address(registerPatientDTO.addressDTO());
        this.active = true;
    }

    public void updatePatientInformation(UpdatePatientInfoDTO updatePatientInfoDTO) {
        if (updatePatientInfoDTO.name() != null) {
            this.name = updatePatientInfoDTO.name();
        }
        if (updatePatientInfoDTO.phone() != null) {
            this.phone = updatePatientInfoDTO.phone();
        }
        if (updatePatientInfoDTO.addressDTO() != null) {
            this.address.updateAddressInformation(updatePatientInfoDTO.addressDTO());
        }
    }

    public void setActiveAsFalse(Long id) {
        this.active = false;
    }
}
