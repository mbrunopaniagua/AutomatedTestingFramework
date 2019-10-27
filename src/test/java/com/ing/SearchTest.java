package com.ing;

import com.ing.pages.HomePage;
import com.ing.pages.SearchPage;
import com.ing.util.CommonVerification;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.ing.pages.HomePage.getHomePage;
import static com.ing.pages.PostPage.linkedSideBar;
import static com.ing.pages.PostPage.voteUpButton;
import static com.ing.pages.SearchPage.getSearchPage;

public class SearchTest extends BaseTest {

    private HomePage home = getHomePage();
    private SearchPage search = getSearchPage();
    private CommonVerification common = CommonVerification.getCommonVerification();

    @Test
    public void test() throws IOException {
        home.search("java");

        search.sortedByMostVoted()
                .selectPost();

        common.verifyIsDisplayed(voteUpButton())
                .verifyIsDisplayed(linkedSideBar());

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
