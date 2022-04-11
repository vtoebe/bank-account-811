package com.vtoebe.bankaccount811.service.impl;

import com.vtoebe.bankaccount811.dto.request.ClientRequest;
import com.vtoebe.bankaccount811.dto.response.ClientResponse;
import com.vtoebe.bankaccount811.model.Client;
import com.vtoebe.bankaccount811.repository.ClientRepository;
import com.vtoebe.bankaccount811.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientResponse create(ClientRequest clientRequest) {
        Client client = new Client(clientRequest);
        client = clientRepository.save(client);
        return new ClientResponse(client);
    }

    @Override
    public ClientResponse update(Integer id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).orElseThrow();

        client.setCpf(clientRequest.getCpf());
        client.setName(clientRequest.getName());
        client.setPassword(clientRequest.getPassword());

        return new ClientResponse(clientRepository.save(client));
    }

    @Override
    public void delete(Integer id) {
        clientRepository.delete(clientRepository.findById(id).orElseThrow());
    }

    @Override
    public Client getById(int id) { return clientRepository.findById(id).orElseThrow(); }

    @Override
    public Page<Client> getAll(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page, size,
                Sort.Direction.ASC, "name"
        );

        if (!Objects.isNull(name)){
            return clientRepository.findByName(name, pageRequest);
        } else{
            return clientRepository.findAll(pageRequest);
        }
    }

    @Override
    public Page<ClientResponse> findByCpf(String cpf, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return clientRepository.findByCpf(cpf, pageRequest);
    }
}
