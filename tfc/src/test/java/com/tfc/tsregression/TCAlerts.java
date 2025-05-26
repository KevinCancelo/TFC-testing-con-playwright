package com.tfc.tsregression;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.POAlerts;
import com.tfc.tshelpers.pageobjects.POHome;


public class TCAlerts extends TCBase{
    @Tag("user1")
    @Tag("user2")
    @Test
    public void JSAlert() {
        
        //Global dialog handler for JavaScript alerts
        getPage().onDialog(dialog -> {
            System.out.println("Texto de la alerta: " + dialog.message());
            dialog.accept(); // Automatically accept alerts
        });  
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickAlerts();// Access the Alerts section
        
        POAlerts poAlerts = new POAlerts(getPage());
        poAlerts.generateJSAlert();
    }
}
