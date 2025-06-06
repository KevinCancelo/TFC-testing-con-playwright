package com.tfc.tshelpers.pagecomponents;

import com.microsoft.playwright.Page;

public class PCLowBar {
    Page page;

// CSS selector for the Selenium link in the page footer
    private static final String SELENIUM_LINK = "#page-footer a";

    // Constructor that assigns the Playwright Page object
    public PCLowBar(Page page){
        this.page = page;
    }

    // Clicks the Selenium link located in the footer
    public void clickSeleniumLink(){
        page.locator(SELENIUM_LINK).click();
    }
}