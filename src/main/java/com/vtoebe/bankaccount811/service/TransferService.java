package com.vtoebe.bankaccount811.service;

import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.dto.response.TransferResponse;
import com.vtoebe.bankaccount811.projection.TransferView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransferService {
    TransferResponse create(TransferRequest transferRequest);
    Page<TransferResponse> listAllTransferFromAccNumber(Integer accNumber, int page, int size);

    List<TransferView> getAllTransferViewByAccNumber(Integer accNumber);
}
