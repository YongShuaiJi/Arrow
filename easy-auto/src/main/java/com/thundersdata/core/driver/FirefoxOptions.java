package com.thundersdata.core.driver;

import org.openqa.selenium.MutableCapabilities;

public class FirefoxOptions implements BrowerCore {
    @Override
    public MutableCapabilities getMutableCapabilities() {
        return new org.openqa.selenium.firefox.FirefoxOptions();
    }
}
