package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class POLogin {

    private Page page;

    private static final String HEADER= "h2";
    private static final String USERNAME= "#username";//# is for ids
    private static final String PASSWORD= "#password";
    private static final String FLASH_SUCCESS = ".flash.success";
    private static final String CONFIRM_LOGIN_BUTTON = "#login .radius";

    public POLogin(Page page){

        this.page = page;
    }    

    public String getHeaderText(){

        return page.locator(HEADER).textContent();
    }

    //Clicks and clears the username field, then types the provided username
    public void fillUsername(String username){

        Locator usernameLocator = page.locator(USERNAME);
        usernameLocator.click();
        usernameLocator.clear();
        usernameLocator.pressSequentially(username);
    }

    public void fillPassword(String password){

        Locator passwordLocator = page.locator(PASSWORD);
        passwordLocator.click();
        passwordLocator.clear();
        passwordLocator.pressSequentially(password);
    }

    public void confirmLogin(){

        page.locator(CONFIRM_LOGIN_BUTTON).click();
    }

    //Waits for the success flash message to appear on the page
    public void waitForFlashSuccessAppear(){

        page.locator(FLASH_SUCCESS).waitFor();
    }
}
