package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POIFrame {
    Page page;

    private static final String IFRAME = "#mce_0_ifr";       // Selector for iframe element
    private static final String TEXT = "p";                   // Selector for paragraph elements
    private static final String CLOSE_MESSAGE = ".tox-button"; // Selector for close button

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
