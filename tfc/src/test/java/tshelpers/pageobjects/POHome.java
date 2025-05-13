package tshelpers.pageobjects;

import com.microsoft.playwright.Page;

//Page Object for the home page.
public class POHome {

    private Page page;

    private static final String ACCEPT_COOKIES_BUTTON = "#onetrust-accept-btn-handler";
    
    public POHome(Page page){

        this.page = page;
    }    

    //Accepts cookies by clicking the consent button.
    public void acceptCookies(){

        page.locator(ACCEPT_COOKIES_BUTTON).click();
    }

}
