package com.ing;

import com.ing.pages.HomePage;
import com.ing.pages.SearchPage;
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
    private SearchPage search = new SearchPage();

    @Test
    public void test() throws IOException {
        home.search("java");

        search.sortedByMostVoted();
        search.selectPost();

        //verify title
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"h-linked\"]")).isDisplayed());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
