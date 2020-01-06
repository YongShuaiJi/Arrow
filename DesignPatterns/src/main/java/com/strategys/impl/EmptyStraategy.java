package com.strategys.impl;

import com.strategys.PromotionStrategy;

public class EmptyStraategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("没有任何促销活动");
    }
}
