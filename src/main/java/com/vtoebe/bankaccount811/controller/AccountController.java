package com.vtoebe.bankaccount811.controller;

import com.vtoebe.bankaccount811.dto.request.AccountRequest;
import com.vtoebe.bankaccount811.dto.response.AccountResponse;
import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(path = "/{id}")
    public AccountResponse create(@PathVariable("id") Integer usuarioId, @RequestBody AccountRequest accountRequest) {
        return accountService.create(usuarioId, accountRequest);
    }

    @RequestMapping(value = "/{accNumber}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("accNumber") Integer accNumber){
        accountService.delete(accNumber);
    }

    @GetMapping("/{id}")
    public Page<AccountResponse> getAllByClientId(@PathVariable("id") Integer id,
                              @RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "10") int size
    ){
        return accountService.getAllAccountsByClientId(id, page, size);
    }

    @GetMapping("/my-account/{accNumber}")
    public Account getAccountByAccNumber(@PathVariable("accNumber") Integer accNumber){
        return accountService.getByAccNumber(accNumber);
    }

    @GetMapping("/my-account")
    public Page<AccountResponse> getAllByAgency(@RequestParam(name = "agency") Integer agency,
                                                @RequestParam(required = false, defaultValue = "0") int page,
                                                @RequestParam(required = false, defaultValue = "10") int size
    ){
        return accountService.getAllAccountsByAgency(agency, page, size);
    }
}
