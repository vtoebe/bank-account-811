package com.vtoebe.bankaccount811.service.impl;

import com.vtoebe.bankaccount811.dto.request.AccountRequest;
import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.dto.response.AccountResponse;
import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.repository.AccountRepository;
import com.vtoebe.bankaccount811.service.AccountService;
import com.vtoebe.bankaccount811.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientService clientService;

    @Override
    public AccountResponse create(Integer clientId, AccountRequest accountRequest) {
        var client = clientService.getById(clientId);
        Account account = new Account(client, accountRequest);
        return new AccountResponse(accountRepository.save(account));
    }

    @Override
    public Account update(Integer accNumber, BigDecimal amount) {
        var account = accountRepository.getByAccNumber(accNumber);
        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }

    @Override
    public void delete(Integer accNumber) {
        accountRepository.delete(accountRepository.getByAccNumber(accNumber));
    }

    @Override
    public Account getByAccNumber(Integer accNumber) {
        return accountRepository.getByAccNumber(accNumber);
    }

    @Override
    public Page<AccountResponse> getAllAccountsByClientId(Integer clientId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return accountRepository.getAllAccountsByClientId(clientId, pageRequest);
    }

    @Override
    public Page<AccountResponse> getAllAccountsByAgency(Integer agency, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return accountRepository.getAllByAgency(agency, pageRequest);
    }
}
