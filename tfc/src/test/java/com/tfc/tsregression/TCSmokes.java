package com.tfc.tsregression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import com.tfc.tshelpers.base.TCBase;

import com.tfc.tshelpers.pageobjects.POHome;

// Smoke test: verifies that the core functionality or page loads correctly as a quick sanity check before deeper testing.
public class TCSmokes extends TCBase{

    private POHome poHome = new POHome(getPage());

    @Tag("ES")
    @Test
    public void shouldLoadHomePage() {
        getPage().navigate(getHomeUrl());
        
        Assertions.assertTrue(poHome.getHeaderText().contains("Welcome to the-internet"), "Does not load header");
    }

    @Tag("ES")
    @Test
    public void shouldDisplayMainNavigationLinks() {
        getPage().navigate(getHomeUrl());

        Assertions.assertTrue(poHome.countLinksTest() > 10); 
    }

}
