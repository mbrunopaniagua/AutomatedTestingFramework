package com.ing;

import com.ing.pages.home.HomePage;
import com.ing.pages.post.PostPage;
import com.ing.pages.search.SearchPage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.ing.pages.home.HomePage.getHomePage;
import static com.ing.pages.post.PostPage.getPostPage;
import static com.ing.pages.search.SearchPage.getSearchPage;

public class SearchTest extends BaseTest {

    private HomePage home = getHomePage();
    private SearchPage search = getSearchPage();
    private PostPage post = getPostPage();

    @Test
    public void test() throws IOException {
        home.act().
                search("java");

        search.act()
                .sortedByMostVoted()
                .selectPost();


        post.verify()
                .isDisplayedLinkedSideBar()
                .isDisplayedVoteUpButton();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("images/screenshot.png"));

    }
}
