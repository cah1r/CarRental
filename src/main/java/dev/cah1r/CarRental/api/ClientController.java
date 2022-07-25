package dev.cah1r.CarRental.api;

import dev.cah1r.CarRental.dto.ClientDto;
import dev.cah1r.CarRental.dto.ClientMapper;
import dev.cah1r.CarRental.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/client/{id}")
    public ClientDto getClient(@PathVariable("id") Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Can't find client with id: " + id));
    }
    @GetMapping("/clients")
    public List<ClientDto> getClientList() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

}
