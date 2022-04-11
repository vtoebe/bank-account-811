package com.vtoebe.bankaccount811.controller;

import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.model.Client;
import com.vtoebe.bankaccount811.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.vtoebe.bankaccount811.enums.AccTypeEnum.PF;
import static com.vtoebe.bankaccount811.enums.AccTypeEnum.PJ;

@DataJpaTest
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    Client client = new Client();
    Client client2 = new Client();

    Account account = new Account();
    Account account2 = new Account();

    @Test
    public void returnEmptyIfRepositoryEmptyOnFindAll(){
        var accounts = accountRepository.findAll();
        Assertions.assertEquals(Arrays.asList(), accounts);
    }

    @Test
    public void returnRegisteredClientsOnFindAll(){
        setClients();
        var accounts = accountRepository.findAll();
        Assertions.assertEquals(Arrays.asList(account, account2), accounts);
    }


    public void setClients(){
        client.setName("Maria");
        client.setPassword("12345677");
        client.setCpf("12312312312");

        client2.setName("Anderson");
        client2.setPassword("12345677");
        client2.setCpf("12312312313");

        entityManager.persist(client);
        entityManager.persist(client2);

        setAccounts();
        entityManager.persist(account);
        entityManager.persist(account2);
    }

    public void setAccounts(){
        account.setClient(client);
        account.setAccNumber(1111);
        account.setAgency(1111);
        account.setAccType(PF);
        account.setBalance(BigDecimal.valueOf(10000.00));

        account2.setClient(client);
        account2.setAccNumber(2222);
        account2.setAgency(2222);
        account2.setAccType(PJ);
        account2.setBalance(BigDecimal.valueOf(10.00));
    }


}