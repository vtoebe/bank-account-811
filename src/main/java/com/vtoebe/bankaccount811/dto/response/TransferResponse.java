package com.vtoebe.bankaccount811.dto.response;

import com.vtoebe.bankaccount811.enums.TransferTypeEnum;
import com.vtoebe.bankaccount811.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class TransferResponse {
    private Integer id;
    private TransferTypeEnum transferType;
    private AccountResponse account;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransferResponse(Transfer transfer){
        this.id = transfer.getId();
        this.transferType = transfer.getTransferType();
        this.account = new AccountResponse(transfer.getAccount());
        this.amount = transfer.getAmount();
        this.createdAt = transfer.getCreatedAt();
    }

}
