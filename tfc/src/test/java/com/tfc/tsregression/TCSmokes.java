package com.tfc.tsregression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Value;

import com.tfc.tshelpers.base.TCBase;

import com.tfc.tshelpers.pageobjects.POHome;

// Smoke test: verifies that the core functionality or page loads correctly as a quick sanity check before deeper testing.
public class TCSmokes extends TCBase{

    @Value("${betsFrame}")
    private String betsFrame;

    @Tag("ES")
    @Test
    void shouldLoadHomePage() {
        getPage().navigate(getHomeUrl());
        POHome poHome = new POHome(getPage());

        Assertions.assertTrue(poHome.getHeaderText().contains("Welcome to the-internet"), "Does not load header");
    }
}
