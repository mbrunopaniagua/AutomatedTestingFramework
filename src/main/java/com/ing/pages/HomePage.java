package com.ing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePage {
    public void search(String value) {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        options.addArguments("--window-size=1920,1200","--ignore-certificate-errors");
        ChromeDriver driver = new ChromeDriver(options);

        //start at home®
        driver.get("http://en.wikipedia.org/");

        // search and enter
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        search.sendKeys(value);
        search.sendKeys(Keys.RETURN);
    }
}
