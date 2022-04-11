package com.vtoebe.bankaccount811.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ValidationError {
    private String field;
    private String errorMessage;
}
