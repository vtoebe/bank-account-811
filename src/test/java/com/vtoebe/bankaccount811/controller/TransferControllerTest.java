package com.vtoebe.bankaccount811.controller;

import com.vtoebe.bankaccount811.enums.TransferTypeEnum;
import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.model.Client;
import com.vtoebe.bankaccount811.model.Transfer;
import com.vtoebe.bankaccount811.repository.AccountRepository;
import com.vtoebe.bankaccount811.repository.TransferRepository;
import com.vtoebe.bankaccount811.service.AccountService;
import com.vtoebe.bankaccount811.service.TransferService;
import com.vtoebe.bankaccount811.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static com.vtoebe.bankaccount811.enums.AccTypeEnum.PF;
import static com.vtoebe.bankaccount811.enums.AccTypeEnum.PJ;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@ActiveProfiles("test")
class TransferControllerTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TransferRepository transferRepository;

    Client client = new Client();
    Client client2 = new Client();

    Account account = new Account();
    Account account2 = new Account();

    Transfer transfer = new Transfer();
    Transfer transfer2 = new Transfer();


    @Test
    public void returnTransferByAccountNumber(){
        setClients();
        PageRequest pageRequest = PageRequest.of(0, 10);
        var transfers = transferRepository.listAllTransferFromAccNumber(1111, pageRequest);
        Assertions.assertEquals(1, transfers.getTotalElements());
        Assertions.assertEquals(transfer, transfers.stream().findFirst().get());
    }

//    @Test
//    void registerTransferWithSucess() throws Exception{
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/transfer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "    \"amount\": 50.00,\n" +
//                                "    \"transferType\": \"TED\",\n" +
//                                "    \"accNumber\": 1111\n}"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").isNotEmpty());
//    }

//    @Test
//    public void updateAccountBalanceOnTransferSuccess(){
//        setClients();
//        Transfer transfer3 = new Transfer();
//        transfer3.setAccount(account);
//        transfer3.setAmount(BigDecimal.valueOf(24.00));
//        transfer3.setTranferType(TransferTypeEnum.PIX);
//
//        entityManager.persist(transfer3);
//
//        Assertions.assertEquals(BigDecimal.valueOf(10124.00), account.getBalance());
//    }


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

        setTransfers();
        entityManager.persist(transfer);
        entityManager.persist(transfer2);
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

    public void setTransfers(){
        transfer.setAccount(account);
        transfer.setTransferType(TransferTypeEnum.DOC);
        transfer.setAmount(BigDecimal.valueOf(100.00));

        transfer2.setAccount(account2);
        transfer2.setTransferType(TransferTypeEnum.PIX);
        transfer2.setAmount(BigDecimal.valueOf(2.00));
    }

}