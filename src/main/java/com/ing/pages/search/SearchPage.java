package com.ing.pages.search;

public class SearchPage {
    private final SearchActController act;

    private SearchPage(SearchActController act) {
        this.act = act;
    }

    public static SearchPage getSearchPage() {
        return new SearchPage(new SearchActController());
    }

    public SearchActController act() {
        return act;
    }
}
