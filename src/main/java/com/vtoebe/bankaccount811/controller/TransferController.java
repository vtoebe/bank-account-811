package com.vtoebe.bankaccount811.controller;

import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.dto.response.TransferResponse;
import com.vtoebe.bankaccount811.model.Transfer;
import com.vtoebe.bankaccount811.projection.TransferView;
import com.vtoebe.bankaccount811.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping()
    public TransferResponse create(@RequestBody @Valid TransferRequest transferRequest){
        return transferService.create(transferRequest);
    }

    @GetMapping("{accNumber}")
    public Page<TransferResponse> getTransferByAccNumber(@PathVariable("accNumber") Integer accNumber,
                                                 @RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "10") int size
    ){
        return transferService.listAllTransferFromAccNumber(accNumber, page, size);
    }

    @GetMapping("/view")
    public List<TransferView> getAllTransferViewByAccNumber(@RequestParam Integer accNumber){
        return transferService.getAllTransferViewByAccNumber(accNumber);
    }

}
