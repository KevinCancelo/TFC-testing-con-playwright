package com.tfc.tsregression;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Download;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.PODownloadFile;
import com.tfc.tshelpers.pageobjects.POHome;
import com.tfc.tshelpers.utils.ReadTxtFile;
import com.tfc.tshelpers.utils.readTxtFile;

public class TCDownloadFile extends TCBase{

    private static final String TEST_FILE_PATH = "target/site/txt/";
    private static final String BY_LINK_FILE_NAME = "downloaded_by_link.txt";

    //Test that verifies a file is downloaded by clicking a link
    @Tag("user1")
    @Tag("user2")
    @Test
    public void DownloadFileByLink() throws IOException{
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickDownloadFile();

        PODownloadFile poDownloadFile = new PODownloadFile(getPage());
        //Wait for the file download after clicking the download link
        Download download = getPage().waitForDownload(() -> {
           poDownloadFile.downloadTxtFile();
        });
        getPage().waitForTimeout(3000);
        //Save the downloaded file to the specified local path
        download.saveAs(Paths.get(TEST_FILE_PATH + BY_LINK_FILE_NAME));

        ReadTxtFile readTxtFile = new ReadTxtFile();
        readTxtFile.readFile(TEST_FILE_PATH + BY_LINK_FILE_NAME);
        
    }

}
