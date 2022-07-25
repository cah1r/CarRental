package dev.cah1r.CarRental.dto;

import dev.cah1r.CarRental.model.Client;

import java.util.stream.Collectors;

class ClientMapper {

    public static ClientDto toDto(Client client) {

        if(client.getType().equals(Client.Type.PERSON)) {
            return ClientDto.builder()
                    .id(client.getId())
                    .name(client.getName())
                    .type(client.getType())
                    .organization(ClientDto.builder()
                            .type(client.getOrganization().getType())
                            .name(client.getOrganization().getName())
                            .build())
                    .build();
        } else {
            return ClientDto.builder()
                    .id(client.getId())
                    .name(client.getName())
                    .type(client.getType())
                    .clients(client.getClients().stream()
                            .map(person -> ClientDto.builder()
                                    .type(person.getType())
                                    .name(person.getName())
                                    .build())
                            .collect(Collectors.toList()))
                    .build();
        }

    }
}
