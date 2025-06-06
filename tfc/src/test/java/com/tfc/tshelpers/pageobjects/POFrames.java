package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POFrames {
    Page page;

    private static final String IFRAME_LINK = "a[href='/iframe']";  // Selector for iframe link

    public POFrames(Page page){

        this.page = page;
    }    

    public void clickIFrames(){
        page.locator(IFRAME_LINK).click();
    }
}
