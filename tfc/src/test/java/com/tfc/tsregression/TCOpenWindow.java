package com.tfc.tsregression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pagecomponents.PCLowBar;

//Test that verifies the Selenium link opens a new window from differents pages
public class TCOpenWindow extends TCBase{
    
    //Verifies from home page
    @Tag("user1")
    @Tag("user2")
    @Test
    public void TCOpenWindowFromHome(){
        getPage().navigate(getHomeUrl());

        //Access the persistent bottom bar component
        PCLowBar pcLowBar = new PCLowBar(getPage());

        //Wait for and capture the popup window after clicking the link
        Page newWindowPage = getPage().waitForPopup(() -> {
            pcLowBar.clickSeleniumLink();
        });

        //Assert the new window navigated to the expected URL
        Assertions.assertTrue(newWindowPage.url().contains("elementalselenium.com"));
    }

}
