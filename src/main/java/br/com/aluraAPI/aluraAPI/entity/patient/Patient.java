package br.com.aluraAPI.aluraAPI.entity.patient;

import br.com.aluraAPI.aluraAPI.entity.address.Address;
import br.com.aluraAPI.aluraAPI.entity.address.AddressDTO;
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

    public Patient(RegisterPatientDTO registerPatientDTO) {
        this.name = registerPatientDTO.name();
        this.email = registerPatientDTO.email();
        this.phone = registerPatientDTO.phone();
        this.cpf = registerPatientDTO.cpf();
        this.address = new Address(registerPatientDTO.addressDTO());
    }
}
