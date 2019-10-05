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

import static com.ing.pages.HomePage.getHomePage;
import static com.ing.pages.PostPage.getPostPage;
import static com.ing.pages.SearchPage.getSearchPage;

public class SearchTest extends BaseTest {

    private HomePage home = getHomePage();
    private SearchPage search = getSearchPage();
    private PostPage post = getPostPage();

    @Test
    public void test() throws IOException {
        home.search("java");

        search.sortedByMostVoted()
                .selectPost();

        post.verifyVoteUpIsDisplayed()
                .verifyLinkedSideBarIsDisplayed();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
