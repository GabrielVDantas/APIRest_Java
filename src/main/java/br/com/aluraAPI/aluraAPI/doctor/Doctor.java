package br.com.aluraAPI.aluraAPI.doctor;

import br.com.aluraAPI.aluraAPI.endereco.Address;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;
}
