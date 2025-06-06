package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POAlerts {
    Page page;

    private static final String JS_ALERT = "[onclick='jsAlert()']";   // Selector for JS alert button
    private static final String JS_CONFIRM = "[onclick='jsConfirm()']"; // Selector for JS confirm button
    private static final String JS_PROMPT = "[onclick='jsPrompt()']";  // Selector for JS prompt button
    private static final String RESULT_TEXT = "#result";               // Selector for result text element

    public POAlerts(Page page){

        this.page = page;
    }    

    public void generateJSAlert(){
       
        page.locator(JS_ALERT).click();
    }

    public void generateJSConfirm(){
       
        page.locator(JS_CONFIRM).click();
    }

    public void generateJSPrompt(){
       
        page.locator(JS_PROMPT).click();
    }

    public String readResultText(){

        return page.locator(RESULT_TEXT).textContent();
    }
}
