package com.tfc.tshelpers.pagecomponents;

import com.microsoft.playwright.Page;
import com.tfc.tshelpers.base.PCHeaderBase;

// Header component implementation for mobile view.
public class PCHeaderMobile extends PCHeaderBase{

    private static final String DESPLEGATE_HEADER_ICON = ".c-main-menu__burguer";
    private static final String MAIN_MENU = ".c-menu-burger__item";

    public PCHeaderMobile(Page page, String language, String country) {
        super(page, language, country);
    }
        
    // Opens burger menu and navigates to the bets section
    public void goToBets(){
        getPage().locator(DESPLEGATE_HEADER_ICON).click();
        getPage().locator(MAIN_MENU).first().click();
    }
}
