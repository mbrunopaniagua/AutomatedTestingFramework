package com.ing.pages.post;

import com.ing.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostVerifyController {
    private WebDriver driver = DriverFactory.getDriver();

    private By voteUpButton() {
        return By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]");
    }

    private By linkedSideBar() {
        return By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]");
    }

    private void isDisplayed(By element) {
        Assertions.assertTrue(driver.findElement(element).isDisplayed());
    }

    public PostVerifyController isDisplayedVoteUpButton() {
        isDisplayed(voteUpButton());
        return this;
    }

    public PostVerifyController isDisplayedLinkedSideBar() {
        isDisplayed(linkedSideBar());
        return this;
    }
}
