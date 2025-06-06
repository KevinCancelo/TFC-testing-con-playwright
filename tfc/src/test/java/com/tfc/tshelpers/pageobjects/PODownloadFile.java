package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PODownloadFile {
    Page page;  

    private static final String DOWNLOAD_LINKS = "a"; // Selector for all links

    public PODownloadFile(Page page){

        this.page = page;
    }

    public void downloadTxtFile(){
        // Clicks on the first .txt file link found on the page
        searchFirstTextFile().click();
    }

    private Locator searchFirstTextFile(){
        // Locates all elements matching the DOWNLOAD_LINKS selector
        Locator downloadLinks = page.locator(DOWNLOAD_LINKS);
                
        for (int i = 0; i < downloadLinks.count(); i++) {
            // If the current element's text contains ".txt", return it
            if (downloadLinks.nth(i).textContent().contains(".txt")){
                return downloadLinks.nth(i);
            }
         
        }

        // If no .txt file is found, return null
        return null;
    }
}
