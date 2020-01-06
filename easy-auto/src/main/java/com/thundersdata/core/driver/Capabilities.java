package com.thundersdata.core.driver;

import org.openqa.selenium.MutableCapabilities;

public class Capabilities {
    private BrowerCore browerCore;

    public Capabilities(BrowerCore browerCore){
        this.browerCore = browerCore;
    }

    public MutableCapabilities getMutableCapabilities(){
        return browerCore.getMutableCapabilities();
    }
}
