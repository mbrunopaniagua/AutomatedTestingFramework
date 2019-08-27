package com.ing.pages;

import com.ing.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver = DriverFactory.getDriver();

    public SearchPage sortedByMostVoted() {
        driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[4]/div/div[2]/div/div[3]/button")).click();
        driver.findElement(By.xpath("//input[@type='radio'][@value='MostVotes']")).click();
        driver.findElement(By.xpath("//*[@id=\"uql-form\"]/div/div/div[2]/div/div[1]/button")).click();
        return this;
    }

    public void selectPost() {
        driver.findElement(By.xpath("//*[@id=\"question-summary-11227809\"]/div[2]/h3/a")).click();
    }
}
