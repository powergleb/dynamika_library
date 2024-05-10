package com.powergleb.dynamika.mapper;


import com.powergleb.dynamika.dto.ClientDto;
import com.powergleb.dynamika.dto.ClientCreateDto;
import com.powergleb.dynamika.entity.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientMapper{

    public List<ClientDto> toDtoList(List<Client> clients) {
        List<ClientDto> dtos = new ArrayList<>();
        for (Client client : clients) {
            dtos.add(toDto(client));
        }
        return dtos;
    }


    public Client toEntity(ClientCreateDto dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setPatronymic(dto.getPatronymic());
        client.setBirthday(dto.getBirthday());
        return client;
    }

    public Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setPatronymic(dto.getPatronymic());
        client.setBirthday(dto.getBirthday());
        return client;
    }

    public ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPatronymic(client.getPatronymic());
        dto.setBirthday(client.getBirthday());
        return dto;
    }
}
