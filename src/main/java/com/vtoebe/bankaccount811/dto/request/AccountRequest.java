package com.vtoebe.bankaccount811.dto.request;

import com.vtoebe.bankaccount811.enums.AccTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter @Setter
public class AccountRequest {

    @NotNull
    private int number;

    @NotNull
    private int agency;

    @NotNull
    private AccTypeEnum accType;

    @NotNull
    private BigDecimal balance;

}
