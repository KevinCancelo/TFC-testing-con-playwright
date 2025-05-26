package com.tfc.tsregression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.POAlerts;
import com.tfc.tshelpers.pageobjects.POHome;

// Tests for handling JavaScript alert, confirm, and prompt dialogs
public class TCAlerts extends TCBase{

    private static final String PROMPT_MESSAGE = "Hola mundo";
    
    // Test simple alert and validate success message
    @Tag("user1")
    @Tag("user2")
    @Test
    public void JSAlert() {
        
        //Global dialog handler for JavaScript alerts
        getPage().onDialog(dialog -> {
            dialog.accept(); // Automatically accept alerts
        });  
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickAlerts();// Access the Alerts section
        
        POAlerts poAlerts = new POAlerts(getPage());
        poAlerts.generateJSAlert();

        Assertions.assertEquals("You successfully clicked an alert", poAlerts.readResultText());
    }

    // Test confirm dialog when user clicks OK
    @Tag("user1")
    @Tag("user2")
    @Test
    public void JSConfirmAcept() {
        
        getPage().onDialog(dialog -> {
            dialog.accept();
        });  
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickAlerts();
        
        POAlerts poAlerts = new POAlerts(getPage());
        poAlerts.generateJSConfirm();

        Assertions.assertEquals("You clicked: Ok", poAlerts.readResultText());
    }

    // Test confirm dialog when user clicks Cancel
    @Tag("user1")
    @Tag("user2")
    @Test
    public void JSConfirmCancel() {
        
        getPage().onDialog(dialog -> {
            dialog.dismiss();// Automatically cancel alerts
        });  
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickAlerts();
        
        POAlerts poAlerts = new POAlerts(getPage());
        poAlerts.generateJSConfirm();

        Assertions.assertEquals("You clicked: Cancel", poAlerts.readResultText());
    }

    // Test prompt dialog and send input value
    @Tag("user1")
    @Tag("user2")
    @Test
    public void JSPrompt() {
        
        getPage().onDialog(dialog -> {
            dialog.accept(PROMPT_MESSAGE);// Automatically add the prompt message and accept alert
        });  
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickAlerts();
        
        POAlerts poAlerts = new POAlerts(getPage());
        poAlerts.generateJSPrompt();

        Assertions.assertEquals("You entered: " + PROMPT_MESSAGE , poAlerts.readResultText());
    }

}
