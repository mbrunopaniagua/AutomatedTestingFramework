package com.ing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;
    private static ChromeOptions options;

    private DriverFactory() {
        //prevent instantiation
    }

    private static ChromeOptions getOptions() {
        if (options == null) {
            options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
//            options.addArguments("--window-size=1920,1200","--ignore-certificate-errors");
        }
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().version("77.0.3865.40").setup();
            driver = new ChromeDriver(getOptions());
        }
        return driver;
    }

}
