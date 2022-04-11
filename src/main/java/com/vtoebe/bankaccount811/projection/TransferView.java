package com.vtoebe.bankaccount811.projection;

import com.vtoebe.bankaccount811.enums.TransferTypeEnum;

import java.math.BigDecimal;

public interface TransferView {
    Integer getId();
    TransferTypeEnum getTransferType();
    BigDecimal getAmount();
    AccountView getAccount();
}
