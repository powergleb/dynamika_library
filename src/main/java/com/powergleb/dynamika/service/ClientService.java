package com.powergleb.dynamika.service;

import com.powergleb.dynamika.entity.Client;
import com.powergleb.dynamika.exception.ClientNotFoundException;
import com.powergleb.dynamika.repo.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService{

    private final ClientRepo clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    public Client updateClient(Client client, long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        client.setId(id);

        return clientRepository.saveAndFlush(client);
    }
}