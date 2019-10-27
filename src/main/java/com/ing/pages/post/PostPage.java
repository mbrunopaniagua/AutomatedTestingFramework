package com.ing.pages.post;

public class PostPage {
    private final PostVerifyController verify;
    private PostPage(PostVerifyController verify) {
        this.verify = verify;
    }

    public static PostPage getPostPage() {
        return new PostPage(new PostVerifyController());
    }

    public PostVerifyController verify() {
        return verify;
    }
}
