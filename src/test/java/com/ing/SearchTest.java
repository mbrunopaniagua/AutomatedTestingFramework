package com.ing;

import com.ing.pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SearchTest extends BaseTest {

    private HomePage home = new HomePage();

    @Test
    public void test() throws IOException {
        home.search("java");

        //filter by most votes
        driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[4]/div/div[2]/div/div[3]/button")).click();
        driver.findElement(By.xpath("//input[@type='radio'][@value='MostVotes']")).click();
        driver.findElement(By.xpath("//*[@id=\"uql-form\"]/div/div/div[2]/div/div[1]/button")).click();

        //select most voted post
        driver.findElement(By.xpath("//*[@id=\"question-summary-11227809\"]/div[2]/h3/a")).click();

        //verify title
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"h-linked\"]")).isDisplayed());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
