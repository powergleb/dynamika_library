package com.powergleb.dynamika.api;

import com.powergleb.dynamika.dto.ClientDto;
import com.powergleb.dynamika.dto.ClientCreateDto;
import com.powergleb.dynamika.entity.Client;
import com.powergleb.dynamika.mapper.ClientMapper;
import com.powergleb.dynamika.service.ClientService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientRestApi {

    private final ClientService clientService;
    private ClientMapper clientMapper = new ClientMapper();


    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(clientMapper.toDtoList(clientService.getAllClients()));
    }


    @PostMapping("/addClient")
    public ResponseEntity<ClientDto> addClient(@Valid @RequestBody ClientCreateDto clientDto) {
        Client addedClient = clientService.addClient(clientMapper.toEntity(clientDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.toDto(addedClient));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDto> updateClient(@Valid @RequestBody ClientCreateDto clientDto, @PathVariable long id) {
        Client updatedClient = clientService.updateClient(clientMapper.toEntity(clientDto), id);

        return ResponseEntity.ok(clientMapper.toDto(updatedClient));
    }

}