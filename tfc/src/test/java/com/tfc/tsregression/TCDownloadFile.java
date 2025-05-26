package com.tfc.tsregression;

import java.nio.file.Paths;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Download;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.PODownloadFile;
import com.tfc.tshelpers.pageobjects.POHome;

public class TCDownloadFile extends TCBase{

    //Test that verifies a file is downloaded by clicking a link
    @Tag("user1")
    @Tag("user2")
    @Test
    public void DownloadFileByLink(){
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickDownloadFile();

        PODownloadFile poDownloadFile = new PODownloadFile(getPage());
        //Wait for the file download after clicking the download link
        Download download = getPage().waitForDownload(() -> {
           poDownloadFile.downloadTxtFile();
        });

        //Save the downloaded file to the specified local path
        download.saveAs(Paths.get("target/site/txt/"));
    }
}
