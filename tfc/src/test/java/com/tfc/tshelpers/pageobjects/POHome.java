package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

//Page Object for the home page.
public class POHome {

    private Page page;

    private static final String HEADER= ".heading";
    private static final String LINKS_TEST = "ul li a";
    
    public POHome(Page page){

        this.page = page;
    }    

    //Get text inside the header.
    public String getHeaderText(){

        return page.locator(HEADER).textContent();
    }

    // Count how many navigation links are present
    public int countLinksTest(){
        return page.locator(LINKS_TEST).count();
    }

}
