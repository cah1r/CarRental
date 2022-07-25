package dev.cah1r.CarRental.dto;

import dev.cah1r.CarRental.model.Client;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ClientDto {
    Long id;
    String name;
    ClientDto organization;
    Client.Type type;
    List<ClientDto> clients;

}
