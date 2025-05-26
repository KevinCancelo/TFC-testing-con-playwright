package com.tfc.tshelpers.pagecomponents;

import com.microsoft.playwright.Page;

public class PCLowBar {
    Page page;

    private static final String SELENIUM_LINK = "#page-footer a";

    public PCLowBar(Page page){

        this.page=page;
    }

    public void clickSeleniumLink(){

        page.locator(SELENIUM_LINK).click();
    }
}
