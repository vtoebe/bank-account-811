package com.vtoebe.bankaccount811.dto.response;

import com.vtoebe.bankaccount811.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ClientResponse {
    private Integer id;
    private String cpf;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientResponse(Client client){
        this.id = client.getId();
        this.cpf = client.getCpf();
        this.name = client.getName();
        this.createdAt = client.getCreatedAt();
        this.updatedAt = client.getUpdatedAt();
    }
}
