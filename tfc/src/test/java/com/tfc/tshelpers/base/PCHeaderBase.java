package com.tfc.tshelpers.base;

import com.microsoft.playwright.Page;
//Base class for header components in the Page Component Model.
//Provides common data and methods.
public abstract class PCHeaderBase {

    private Page page;
    private String language;
    private String country;

    public Page getPage() {
        return page;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public PCHeaderBase(Page page, String language, String country) {
        this.page = page;
        this.language = language;
        this.country = country;
    }
    
    // Force subclasses to implement navigation to the bets section
    abstract public void goToBets();
}
