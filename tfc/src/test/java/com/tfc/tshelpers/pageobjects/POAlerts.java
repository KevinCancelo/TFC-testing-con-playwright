package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POAlerts {
    Page page;

    private static final String JS_ALERT = "[onclick='jsAlert()']";
    private static final String JS_CONFIRM = "[onclick='jsConfirm()']";
    private static final String RESULT_TEXT = "#result";

    public POAlerts(Page page){

        this.page = page;
    }    

    public void generateJSAlert(){
       
        page.locator(JS_ALERT).click();
    }

    public void generateJSConfirm(){
       
        page.locator(JS_CONFIRM).click();
    }

    public String readResultText(){

        return page.locator(RESULT_TEXT).textContent();
    }
}
