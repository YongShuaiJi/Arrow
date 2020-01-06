package com.Design;

import java.math.BigDecimal;

public class CashRebate implements CashSuper {

    private BigDecimal coefficient;

    public CashRebate(BigDecimal coefficient){
        this.coefficient = coefficient;
    }

    public BigDecimal acceptCash(BigDecimal money) {
        return money.multiply(coefficient);
    }
}
