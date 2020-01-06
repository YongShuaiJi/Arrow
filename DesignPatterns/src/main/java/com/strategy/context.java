package com.strategy;

public class context {
    private strategy strategy;

    public context(strategy strategy){
        this.strategy = strategy;
    }

    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }
}
