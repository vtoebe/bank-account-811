package com.vtoebe.bankaccount811.repository;

import com.vtoebe.bankaccount811.dto.response.AccountResponse;
import com.vtoebe.bankaccount811.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer>,
        JpaSpecificationExecutor<Account>
{
//    @Query("select new com.vtoebe.bankaccount811.dto.response.AccountResponse(a.accNumber, a.agency, a.accType, a.balance, a.createdAt, a.updatedAt, a.client) from Account a where a.agency = :agency")
    Page<AccountResponse> getAllByAgency(@Param("agency") Integer agency, Pageable pageable);

    Page<AccountResponse>getAllAccountsByClientId(@Param("clientId") Integer clientId, Pageable pageable);

    @Query("select ac from Account ac where ac.accNumber = :accNumber")
    Account getByAccNumber(@Param("accNumber") Integer accNumber);
}
