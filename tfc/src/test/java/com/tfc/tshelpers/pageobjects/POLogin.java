package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class POLogin {

    private Page page;

    private static final String HEADER= "h2";

    public POLogin(Page page){

        this.page = page;
    }    

    
    public String getHeaderText(){

        return page.locator(HEADER).textContent();
    }
}
