package com.vtoebe.bankaccount811.repository;

import com.vtoebe.bankaccount811.dto.response.ClientResponse;
import com.vtoebe.bankaccount811.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer>,
        JpaSpecificationExecutor<Client>
{

    @Query("select new com.vtoebe.bankaccount811.dto.response.ClientResponse(c.id, c.cpf, c.name, c.createdAt, c.updatedAt) from Client c where c.cpf = :cpf")
    Page<ClientResponse> findByCpf(@Param("cpf") String cpf, Pageable pageable);

    Page<Client> findByName(String name, Pageable pageable);
}
