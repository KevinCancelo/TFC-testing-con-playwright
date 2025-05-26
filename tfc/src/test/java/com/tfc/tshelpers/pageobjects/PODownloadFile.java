package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class PODownloadFile {
    Page page;  

    private static final String TXT_FILE = "a[href='download/test_upload.txt']"; 

    public PODownloadFile(Page page){

        this.page = page;
    }

    public void downloadTxtFile(){

        page.locator(TXT_FILE).click();
    }
}
