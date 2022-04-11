package com.vtoebe.bankaccount811.controller;

import com.vtoebe.bankaccount811.dto.request.ClientRequest;
import com.vtoebe.bankaccount811.dto.response.ClientResponse;
import com.vtoebe.bankaccount811.model.Client;
import com.vtoebe.bankaccount811.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ClientResponse create(@RequestBody @Valid ClientRequest clientRequest){
        return clientService.create(clientRequest);
    }

    @GetMapping(path = "{id}")
    public ClientResponse getClientById(@PathVariable("id") Integer id){
        return new ClientResponse(clientService.getById(id));
    }

    @PutMapping(path = "/{id}")
    public ClientResponse update(@PathVariable("id") Integer id, @RequestBody @Valid ClientRequest clientRequest){
        return clientService.update(id, clientRequest);
    };

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){ clientService.delete(id); }

    @GetMapping
    public Page<Client> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ){
        return clientService.getAll(name, page, size);
    }

    @GetMapping("/cpf")
    public Page<ClientResponse> getAllByCpf(@RequestParam(required = false) String cpf,
                            @RequestParam(required = false, defaultValue = "0") int page,
                            @RequestParam(required = false, defaultValue = "10") int size)
    {
        return clientService.findByCpf(cpf, page, size);

    }
}
