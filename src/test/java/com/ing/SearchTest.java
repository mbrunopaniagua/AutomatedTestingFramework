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
}
