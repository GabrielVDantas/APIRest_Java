package br.com.aluraAPI.aluraAPI.entity.address;

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

    private String publicPlace;

    private String neighborhood;

    private String cep;

    private String city;

    private String fu;

    private String complement;

    private String number;

    public Address(AddressDTO addressDTO) {
        this.publicPlace = addressDTO.publicPlace();
        this.neighborhood = addressDTO.neighborhood();
        this.cep = addressDTO.cep();
        this.city = addressDTO.city();
        this.fu = addressDTO.fu();
        this.complement = addressDTO.complement();
        this.number = addressDTO.number();
    }

    public void updateAddressInformation(AddressDTO addressDTO) {
        if (addressDTO.publicPlace() != null) {
            this.publicPlace = addressDTO.publicPlace();
        }
        if (addressDTO.neighborhood() != null) {
            this.neighborhood = addressDTO.neighborhood();
        }
        if (addressDTO.cep() != null) {
            this.cep = addressDTO.cep();
        }
        if (addressDTO.city() != null) {
            this.city = addressDTO.city();
        }
        if (addressDTO.fu() != null) {
            this.fu = addressDTO.fu();
        }
        if (addressDTO.complement() != null) {
            this.complement = addressDTO.complement();
        }
        if (addressDTO.number() != null) {
            this.number = addressDTO.number();
        }
    }
}
