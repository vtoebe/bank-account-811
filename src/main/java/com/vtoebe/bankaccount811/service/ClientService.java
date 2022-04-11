package com.vtoebe.bankaccount811.service;

import com.vtoebe.bankaccount811.dto.request.ClientRequest;
import com.vtoebe.bankaccount811.dto.response.ClientResponse;
import com.vtoebe.bankaccount811.model.Client;
import org.springframework.data.domain.Page;

public interface ClientService {
    ClientResponse create(ClientRequest clientRequest);
    ClientResponse update(Integer id, ClientRequest clientRequest);
    void delete(Integer id);

    Client getById(int id);
    Page<Client> getAll(String name, int page, int size);
    Page<ClientResponse> findByCpf(String cpf, int page, int size);
}
