package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Frame;

//Page Object for the bets section inside an iframe.
public class POBets {
    
    private Frame frame;

    private static final String PICK_BUTTON = ".lp-event__pick-content:visible";


    public POBets(Frame frame){

        this.frame = frame;
    }    

    //Clicks the first visible pick button to add a bet
    public void addFirstBet(){

        frame.locator(PICK_BUTTON).first().click();
    }
}
