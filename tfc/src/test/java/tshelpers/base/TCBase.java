package tshelpers.base;

import tshelpers.conf.AppConfig;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

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


    public Page getPage() {
        return page;
    }
    
    public static void initPlaywright(){

        playwright = Playwright.create();
    }

    public void initBrowser(){

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    public void initContext() {

        context = browser.newContext();
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

    // Runs before each individual test
    // Sets up a fresh browser, context, and page for test isolation
    @BeforeEach
    public void initTC(){

        initBrowser();
        initContext();
        initPage();
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

