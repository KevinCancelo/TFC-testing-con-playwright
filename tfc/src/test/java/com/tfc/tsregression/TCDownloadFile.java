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
import com.tfc.tshelpers.utils.ExampleTxtDataJsonReader;
import com.tfc.tshelpers.utils.TxtFileReader;

public class TCDownloadFile extends TCBase{

    private static final String TEST_FILE_PATH = "target/site/txt/";
    private static final String BY_LINK_FILE_NAME = "downloaded_by_link.txt";
    private static final String JSON_TEXT_TYPE = "example_text";
    private String env = System.getProperty("env");
    private String JSON_EXAMPLE_TXT_PATH = "src/test/resources/data/" + env + "/example_txt.json";

    private String readJsonText(){
        ExampleTxtDataJsonReader exampleTxtDataJsonReader = new ExampleTxtDataJsonReader();
        exampleTxtDataJsonReader.readExampleTextDataFromJson(JSON_EXAMPLE_TXT_PATH, JSON_TEXT_TYPE);

        return exampleTxtDataJsonReader.getTextContent();
    }

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

        String downloadText = readDownloadFile(BY_LINK_FILE_NAME);

        String jsonText = readJsonText();

        Assertions.assertTrue(jsonText.equals(downloadText));

    }

}
