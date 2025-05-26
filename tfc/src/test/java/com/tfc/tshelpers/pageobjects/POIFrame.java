package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POIFrame {
    Page page;

    private static final String IFRAME = "#mce_0_ifr";
    private static final String TEXT = "p";
    private static final String CLOSE_MESSAGE = ".tox-button";

    public POIFrame(Page page){

        this.page = page;
    }    

    public void closeMessage(){

        page.locator(CLOSE_MESSAGE).click();
    }

    //Reads the text inside a <p> element within an iframe.
    public String readText(){

        return page.frameLocator(IFRAME).locator(TEXT).textContent();
    }
}
