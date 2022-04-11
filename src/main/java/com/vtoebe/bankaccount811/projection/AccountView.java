package com.vtoebe.bankaccount811.projection;

import com.vtoebe.bankaccount811.enums.AccTypeEnum;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface AccountView {
    @Value("#{target.accNumber + ' | ' + target.agency}")
    String getAccNumber();
    AccTypeEnum getAccType();
    BigDecimal getBalance();
    ClientView getClient();
}
