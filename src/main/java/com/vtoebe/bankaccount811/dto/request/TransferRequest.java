package com.vtoebe.bankaccount811.dto.request;

import com.vtoebe.bankaccount811.enums.TransferTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter @Setter
public class TransferRequest {
    @NotNull
    private BigDecimal amount;

    @NotNull
    private TransferTypeEnum transferType;

    @NotNull
    private Integer accNumber;
}
