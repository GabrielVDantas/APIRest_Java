package br.com.aluraAPI.aluraAPI.endereco;

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
