package com.vtoebe.bankaccount811.service;

import com.vtoebe.bankaccount811.dto.request.AccountRequest;
import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.dto.response.AccountResponse;
import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.model.Transfer;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface AccountService {
    AccountResponse create(Integer clientId, AccountRequest accountRequest);
    Account update(Integer accNumber, BigDecimal amount);
    void delete(Integer accNumber);

    Account getByAccNumber(Integer accNumber);
    Page<AccountResponse> getAllAccountsByClientId(Integer clientId, int page, int size);

    Page<AccountResponse> getAllAccountsByAgency(Integer agency, int page, int size);
}
