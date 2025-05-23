package com.tfc.tsregression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import com.tfc.tshelpers.base.TCBase;

import com.tfc.tshelpers.pageobjects.POHome;
import com.tfc.tshelpers.pageobjects.POLogin;

// Smoke test: verifies that the core functionality or page loads correctly as a quick sanity check before deeper testing.
public class TCSmokes extends TCBase{

    // Smoke test: Verifies that the home page loads and the header is displayed
    @Tag("ES")
    @Test
    public void shouldLoadHomePage() {
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        
        Assertions.assertTrue(poHome.getHeaderText().contains("Welcome to the-internet"), "Does not load header");
    }

    // Smoke test: Ensures that the main navigation links are present and visible
    @Tag("ES")
    @Test
    public void shouldDisplayMainNavigationLinks() {
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());

        Assertions.assertTrue(poHome.countLinksTest() > 10, "Does not load links"); 
    }

    // Smoke test: Checks that the login link navigates to the correct login page
    @Tag("ES")
    @Test
    public void shouldNavigateToLoginPage() {
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickLogin();
        POLogin poLogin = new POLogin(getPage());
        
        Assertions.assertTrue(getPage().url().contains("/login"), "The link does not lead to the correct URL");
        Assertions.assertTrue(poLogin.getHeaderText().contains("Login Page"), "Does not load login header");
    }
}
