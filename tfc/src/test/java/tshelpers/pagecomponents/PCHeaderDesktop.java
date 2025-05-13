package tshelpers.pagecomponents;

import com.microsoft.playwright.Page;

import tshelpers.base.PCHeaderBase;

// Header component implementation for desktop view.
public class PCHeaderDesktop extends PCHeaderBase {

    private static final String MAIN_MENU = "a.c-main-menu__link";

    public PCHeaderDesktop(Page page, String language, String country) {
        super(page, language, country);
    }
    
    // Clicks the first main menu link to navigate to the bets section
    public void goToBets(){
        getPage().locator(MAIN_MENU).first().click();
    } 
}
