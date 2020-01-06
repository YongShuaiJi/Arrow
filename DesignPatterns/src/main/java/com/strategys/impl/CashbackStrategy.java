package com.strategys.impl;

import com.strategys.PromotionStrategy;

public class CashbackStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("促销返现");
    }
}
