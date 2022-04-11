package com.vtoebe.bankaccount811.dto.response;

import com.vtoebe.bankaccount811.enums.AccTypeEnum;
import com.vtoebe.bankaccount811.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class AccountResponse {
    private Integer accNumber;
    private Integer agency;
    private AccTypeEnum accType;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ClientResponse client;

    public AccountResponse(Account account){
        this.accNumber = account.getAccNumber();
        this.agency = account.getAgency();
        this.accType = account.getAccType();
        this.balance = account.getBalance();
        this.createdAt = account.getCreatedAt();
        this.updatedAt = account.getCreatedAt();
        this.client = new ClientResponse(account.getClient());
    }
}
