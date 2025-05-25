package com.tfc.tsregression;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.TimeoutError;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.POHome;
import com.tfc.tshelpers.pageobjects.POLogin;

// Login test: Navigates to the login page, performs a login, and verifies that a success message appears
public class TCLogin extends TCBase{

    @Tag("user1")
    @Test
    public void login() {
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickLogin();// Access the login section
    
        // Enter valid login credentials
        POLogin poLogin = new POLogin(getPage());
        poLogin.fillUsername(getUsername());
        poLogin.fillPassword(getPassword());
        poLogin.confirmLogin();
        
        try{
            // Wait for login confirmation message to appear
            poLogin.waitForFlashSuccessAppear();
        }catch(TimeoutError te){
            Assertions.fail("Login failed: success message did not appear");
        }
    }
}
