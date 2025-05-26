package com.tfc.tshelpers.pageobjects;

import com.microsoft.playwright.Page;

public class PODownloadFile {
    Page page;  

    private static final String TXT_FILE = "a";     //"a[href='download/test_upload.txt']"; acaban de actualizar ahora mismo la página web, esperar a que metan todos los archivos

    public PODownloadFile(Page page){

        this.page = page;
    }

    public void downloadTxtFile(){

        page.locator(TXT_FILE).first().click();
    }
}
