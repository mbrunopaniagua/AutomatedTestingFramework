package com.ing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;
    protected long startTime;

    @BeforeEach
    public void startUpBrowser() {
        startTime = System.nanoTime();
        System.setProperty("webdriver.chrome.driver", "/Users/mbruno/Katas/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
        System.out.println(((System.nanoTime() - startTime)/1000000000));
    }
}
