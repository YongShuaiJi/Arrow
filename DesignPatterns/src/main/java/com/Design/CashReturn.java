package com.Design;

import java.math.BigDecimal;

/**
 * 满A(实际金额) 返 B(代金券金额）
 * A moneyCondition
 * B moneyReturn
 * */
public class CashReturn implements CashSuper {

    private BigDecimal moneyCondition;
    private BigDecimal moneyReturn;

    public CashReturn(BigDecimal moneyCondition,BigDecimal moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyCondition;
    }

    public BigDecimal acceptCash(BigDecimal money) {
        BigDecimal result = BigDecimal.valueOf(0);
        if (money.compareTo(moneyCondition) == 1 || money.compareTo(moneyCondition) == 0)  result = moneyReturn;
        return result;
    }
}
