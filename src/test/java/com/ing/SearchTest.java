package com.ing;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class SearchTest {
    private WebDriver driver;
    private long startTime;

    @BeforeEach
    public void startUpBrowser() {
        startTime = System.nanoTime();
        System.setProperty("webdriver.chrome.driver", "/Users/mbruno/Katas/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);


    }

    @Test
    public void test() throws IOException {
        //start at home
        driver.get("http://en.wikipedia.org/");

        // search and enter
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        search.sendKeys("java");
        search.sendKeys(Keys.RETURN);

        //select tab
        driver.findElement(By.xpath("//*[@id=\"ca-history\"]/span/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"firstHeading\"]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"firstHeading\"]")).getText().contains("Revision history"));

        //Compare article
        driver.findElement(By.xpath("//*[@id=\"mw-history-compare\"]/div[1]/input")).click();

        //verify title
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"firstHeading\"]")).isDisplayed());
        Assertions.assertEquals("Java: Difference between revisions", driver.findElement(By.xpath("//*[@id=\"firstHeading\"]")).getText());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
        System.out.println(((System.nanoTime() - startTime)/1000000000));
    }
}
