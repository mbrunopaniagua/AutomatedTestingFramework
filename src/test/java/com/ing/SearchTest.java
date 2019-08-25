package com.ing;

import com.ing.pages.HomePage;
import com.ing.pages.PostPage;
import com.ing.pages.SearchPage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SearchTest extends BaseTest {

    private HomePage home = new HomePage();
    private SearchPage search = new SearchPage();
    private PostPage post = new PostPage();

    @Test
    public void test() throws IOException {
        home.search("java");

        search.sortedByMostVoted();
        search.selectPost();

        post.verifyVoteUpIsDisplayed();
        post.verifyLinkedSideBarIsDisplayed();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
