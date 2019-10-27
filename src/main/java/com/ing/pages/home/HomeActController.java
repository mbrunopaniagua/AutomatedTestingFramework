package com.ing.pages.home;

import com.ing.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeActController {
    private WebDriver driver = DriverFactory.getDriver();

    public void search(String value) {
        // search and enter
        WebElement search = driver.findElement(By.xpath("//*[@id=\"search\"]/div/input"));
        search.sendKeys(value);
        search.sendKeys(Keys.RETURN);
    }
}
