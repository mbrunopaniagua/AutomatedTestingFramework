package com.ing.util;

import com.ing.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonVerification {
    protected WebDriver driver = DriverFactory.getDriver();

    private CommonVerification() {
        // hide it
    }

    public static CommonVerification getCommonVerification() {
        return new CommonVerification();
    }

    public CommonVerification verifyIsDisplayed(By element) {
        Assertions.assertTrue(driver.findElement(element).isDisplayed());
        return this;
    }
}
