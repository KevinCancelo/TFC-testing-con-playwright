package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

//Page Object for the home page.
public class POHome {

    private Page page;

    private static final String HEADER= ".heading";//. is for class
    private static final String LINKS_TEST = "ul li a"; //Selects all <a> elements inside <li> inside <ul>
    private static final String LOGIN_LINK = "a[href='/login']";//[] for specific stributtes
    private static final String FRAMES_LINK = "a[href='/frames']";
    
    public POHome(Page page){

        this.page = page;
    }    

    //Get text inside the header.
    public String getHeaderText(){

        return page.locator(HEADER).textContent();
    }

    //Count how many navigation links are present
    public int countLinksTest(){

        return page.locator(LINKS_TEST).count();
    }

    //Click login link
    public void clickLogin (){

        page.locator(LOGIN_LINK).click();
    }

    public void clickFrames (){

        page.locator(FRAMES_LINK).click();
    }
}
