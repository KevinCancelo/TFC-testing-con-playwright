package com.tfc.tsregression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Value;

import com.microsoft.playwright.Frame;
import com.tfc.tshelpers.base.PCHeaderBase;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pagecomponents.PCHeaderFactory;
import com.tfc.tshelpers.pageobjects.POBets;
import com.tfc.tshelpers.pageobjects.POHome;

//Test case: places a simple bet from the homepage.
public class TCSimpleBet extends TCBase{

    @Value("${betsFrame}")
    private String betsFrame;

    private Frame frame;

    @Tag("ES")
    @Test
    public void TCSimpleBet(){

        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.acceptCookies();

        // Create the appropriate header component (desktop or mobile) based on context
        PCHeaderBase tcHeader = PCHeaderFactory.createPCHeader(getPage(),getLanguage(), getCountry());
        tcHeader.goToBets();

        // Select the appropriate frame to interact with the betting section
        if (betsFrame.equals("mainFrame")) frame = getPage().mainFrame(); else frame = getPage().frame(betsFrame);

        POBets poBets = new POBets(frame);
        poBets.addFirstBet();// Place the first available bet
    }
}
