package com.tfc.tshelpers.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.tfc.tshelpers.conf.AppConfig;

import io.qameta.allure.Allure;

import java.nio.file.Paths;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Load properties from the environment-specific config file
@TestPropertySource("classpath:conf/${env}/user.properties")// ${env} is injected from Maven (e.g., -Denv=dev)
// Load Spring context with application configuration
@ContextConfiguration(classes = AppConfig.class)
// Integrate Spring test lifecycle with JUnit 5
@ExtendWith(SpringExtension.class)
public class TCBase {

    // ${} syntax is used to reference external variables    
    @Value("${homeUrl}")
    private String homeUrl;
    @Value("${country}")
    private String country;
    @Value("${language}")
    private String language;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    
    private static Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public String getHomeUrl(){
        return homeUrl;
    }

    public String getCountry(){
        return country;
    }

    public String getLanguage(){
        return language;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Page getPage() {
        return page;
    }
    
    public static void initPlaywright(){

        playwright = Playwright.create();
    }

    // Select browser by maven, deafult Chromium
    public void initBrowser() {
 
        String browserOption = System.getProperty("browser").toUpperCase();
        boolean headlessOption = Boolean.parseBoolean(System.getProperty("headless").toLowerCase());
 
        switch (browserOption) {
            case "CHROME":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessOption));
                break;
            case "FIREFOX":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headlessOption));
                break;
            case "SAFARI":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headlessOption));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessOption));
                break;
        }
    }
    private Browser.NewContextOptions setBrowserContextOptions()
    {

        return new Browser.NewContextOptions()
                .setViewportSize(Integer.valueOf(System.getProperty("viewportWidth")), Integer.valueOf(System.getProperty("viewportHeight")))
                .setDeviceScaleFactor(Integer.valueOf(System.getProperty("deviceScaleFactor")))
                .setIsMobile(Boolean.parseBoolean(System.getProperty("isMobile").toLowerCase()))
                .setRecordVideoDir(Paths.get("target/site/videos/"));
    }

    public void initContext() {

        context = browser.newContext(setBrowserContextOptions());
    }
    
    public void initPage() {

        page = context.newPage();
    }
 
    public static void tearDownPlaywright() {

        playwright.close();
    }
 
    public void tearDownBrowser() {

        browser.close();
    }
 
    public void tearDownContext() {

        context.close();
    }
    
    public void tearDownPage() {

        page.close();
    }
    
    // Runs once before all tests in the suite
    // Sets up the Playwright engine
    @BeforeAll
    public static void initTS(){initPlaywright();}

    // Sets a custom Allure suite name and history ID based on test configuration properties
    private void prepareTestInfoForReports()
    {

        String testSuiteId = System.getProperty("tags").toUpperCase()+
                "_" + System.getProperty("browser").toUpperCase() +
                "_" + System.getProperty("viewportWidth").toUpperCase() +
                "x" + System.getProperty("viewportHeight").toUpperCase() +
                "_scaleFactor:" + System.getProperty("deviceScaleFactor").toUpperCase() +
                "_isMobile:" + System.getProperty("isMobile").toUpperCase();

        Allure.getLifecycle().updateTestCase(testResult -> testResult.getLabels().removeIf(label -> "suite".equals(label.getName())));
        Allure.suite(testSuiteId);

        Allure.getLifecycle().updateTestCase(testResult -> testResult.setHistoryId(UUID.nameUUIDFromBytes((testResult.getName().toString()+testSuiteId).getBytes()).toString()));
    }
    
    // Runs before each individual test
    // Sets up a fresh browser, context, and page for test isolation
    @BeforeEach
    public void initTC(){

        initBrowser();
        initContext();
        initPage();

        prepareTestInfoForReports();
    }

    // Runs after each individual test
    // Cleans up the page, context, and browser to avoid state leakage
    @AfterEach
    public void tearDownTC() {

       tearDownPage();
       tearDownContext();
       tearDownBrowser();
    }
 
    // Runs once after all tests are done
    // Closes the Playwright engine
    @AfterAll
    public static void tearDownTS(){ tearDownPlaywright(); }
}

