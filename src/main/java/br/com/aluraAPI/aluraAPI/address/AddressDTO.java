package br.com.aluraAPI.aluraAPI.address;

public record AddressDTO(

        String publicPlace,

        String neighborhood,

        String cep,

        String city,

        String fu,

        String complement,

        String number
) {
}
