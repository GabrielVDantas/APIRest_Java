package br.com.aluraAPI.aluraAPI.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private  String publicPlace;

    private String neighborhood;

    private String cep;

    private String city;

    private String fu;

    private String complement;

    private String number;
}
