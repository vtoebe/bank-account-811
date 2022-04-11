package com.vtoebe.bankaccount811.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ClientView {
    @Value("#{target.cpf + ' | ' + target.name}")
    String getCpf();
}
