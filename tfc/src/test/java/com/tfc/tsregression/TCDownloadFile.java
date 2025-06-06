package com.tfc.tsregression;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Download;
import com.tfc.tshelpers.base.TCBase;
import com.tfc.tshelpers.pageobjects.PODownloadFile;
import com.tfc.tshelpers.pageobjects.POHome;
import com.tfc.tshelpers.utils.TxtFileReader;

public class TCDownloadFile extends TCBase{

    // ALERT
    // Files are updated frequently, so this test may produce a false negative 
    // if there are no .txt files available at the moment. 
    // In that case, check the link https://the-internet.herokuapp.com/download 
    // or try running the test again later.
    
    private static final String TEST_FILE_PATH = "target/site/txt/";
    private static final String BY_LINK_FILE_NAME = "downloaded_by_link.txt";

    private String readDownloadFile (String fileName) throws IOException{
        TxtFileReader txtFileReader = new TxtFileReader();
        txtFileReader.readFile(TEST_FILE_PATH + fileName);
        
        return txtFileReader.getTextContent();
    }

    //Test that verifies a file is downloaded by clicking a link
    @Tag("user1")
    @Tag("user2")
    @Test
    public void downloadFileByLink() throws IOException{
        getPage().navigate(getHomeUrl());
        
        POHome poHome = new POHome(getPage());
        poHome.clickDownloadFile();

        PODownloadFile poDownloadFile = new PODownloadFile(getPage());
        //Wait for the file download after clicking the download link
        Download download = getPage().waitForDownload(() -> {
           poDownloadFile.downloadTxtFile();
        });
        
        //Save the downloaded file to the specified local path
        download.saveAs(Paths.get(TEST_FILE_PATH + BY_LINK_FILE_NAME));

        // Verifies the file was downloaded with content
        String downloadText = readDownloadFile(BY_LINK_FILE_NAME);
        Assertions.assertTrue(downloadText.length()>0);

    }

}
