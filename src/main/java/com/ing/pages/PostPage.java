package com.ing.pages;

import org.openqa.selenium.By;

public class PostPage {
    private PostPage() {
        // hide it
    }

    public static By voteUpButton() {
        return By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]");
    }

    public static By linkedSideBar() {
        return By.xpath("//*[@id=\"question\"]/div[2]/div[1]/div/button[1]");
    }
}
