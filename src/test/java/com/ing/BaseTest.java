package com.ing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    WebDriver driver;
    long startTime;

    @BeforeAll
    public void startUpBrowser() {
        startTime = System.nanoTime();
        driver = DriverFactory.getDriver();
    }

    @BeforeEach
    public void goToHome() {
        driver.get("http://en.wikipedia.org/");
    }

    @AfterAll
    public void closeBrowser() {
        driver.close();
        System.out.println(((System.nanoTime() - startTime)/1000000000));
    }
}
