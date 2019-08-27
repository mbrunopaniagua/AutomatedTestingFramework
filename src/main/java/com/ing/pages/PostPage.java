package com.ing.pages;

import com.ing.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;

public class PostPage {
    private WebDriver driver = DriverFactory.getDriver();

    public PostPage verifyVoteUpIsDisplayed() {
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]")).isDisplayed());
        return this;
    }

    public PostPage verifyLinkedSideBarIsDisplayed() {
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"h-linked\"]")).isDisplayed());
        return this;
    }
}
