package com.vtoebe.bankaccount811.service.impl;

import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.dto.response.TransferResponse;
import com.vtoebe.bankaccount811.model.Account;
import com.vtoebe.bankaccount811.model.Transfer;
import com.vtoebe.bankaccount811.projection.TransferView;
import com.vtoebe.bankaccount811.repository.TransferRepository;
import com.vtoebe.bankaccount811.service.AccountService;
import com.vtoebe.bankaccount811.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountService accountService;

    @Override
    public TransferResponse create(TransferRequest transferRequest) {
        Transfer transfer = new Transfer(transferRequest);

        Account updatedAccount = accountService.update(transferRequest.getAccNumber(), transferRequest.getAmount());

        transfer.setAccount(updatedAccount);
        transferRepository.save(transfer);

        return new TransferResponse(transfer);
    }

    @Override
    public Page<TransferResponse> listAllTransferFromAccNumber(Integer accNumber, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return transferRepository.listAllTransferFromAccNumber(accNumber, pageRequest);
    }

    @Override
    public List<TransferView> getAllTransferViewByAccNumber(Integer accNumber) {
        return transferRepository.findAllByAccount_AccNumber(accNumber);
    }
}
