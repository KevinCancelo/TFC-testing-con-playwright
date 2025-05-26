package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POAlerts {
    Page page;

    private static final String JS_ALERT = "[onclick='jsAlert()']";

    public POAlerts(Page page){

        this.page = page;
    }    

    public void generateJSAlert(){
       
        page.locator(JS_ALERT).click();
    }

}
