package com.ing.pages.home;

public class HomePage {
    private final HomeActController act;

    private HomePage(HomeActController act) {
        this.act = act;
    }

    public static HomePage getHomePage() {
        return new HomePage(new HomeActController());
    }

    public HomeActController act() {
        return act;
    }
}
