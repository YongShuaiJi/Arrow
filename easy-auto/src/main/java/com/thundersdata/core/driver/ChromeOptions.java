package com.thundersdata.core.driver;

import org.openqa.selenium.MutableCapabilities;

public class ChromeOptions implements BrowerCore {
    @Override
    public MutableCapabilities getMutableCapabilities() {
        return new org.openqa.selenium.chrome.ChromeOptions();
    }
}
