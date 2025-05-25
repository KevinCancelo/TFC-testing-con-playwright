package com.tfc.tsregression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.POFrames;
import com.tfc.tshelpers.pageobjects.POHome;
import com.tfc.tshelpers.pageobjects.POIFrame;

//An iframe embeds another HTML document; we must access it explicitly.
//Tests reading text from an iframe
public class TCIFrame extends TCBase{

    @Tag("user1")
    @Tag("user2")
    @Test
    public void iFrame() {
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickFrames();// Access the frames section
    
        POFrames poFrames = new POFrames(getPage());
        poFrames.clickIFrames();

        POIFrame poiFrame = new POIFrame(getPage());
        poiFrame.closeMessage();// Close popup message
        Assertions.assertEquals("Your content goes here.",poiFrame.readText(), "Incorrect text");
    }
}