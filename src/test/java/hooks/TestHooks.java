package hooks;

import Utils.ScreenshotUtils;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import world.PageObjectWorld;

public class TestHooks {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private static Page page;
    private PageObjectWorld pageObjectWorld;

    @Before
    public void setUp() {

        try {
            System.out.println("Initializing Playwright...");
            playwright = Playwright.create();
            System.out.println("Launching Chromium browser...");
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
            System.out.println("Browser launched successfully.");
            pageObjectWorld = new PageObjectWorld(page);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Playwright or launch the browser.", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && page != null) {
            ScreenshotUtils.captureScreenshot(page, scenario.getName().replaceAll(" ", "_"));
        }
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public static Page getPage() {
        if(page == null){
            throw new IllegalStateException("Page has not been initialized.");
        }
        return page;
    }

    public PageObjectWorld getPageObjectWorld() {
        return pageObjectWorld;
    }
}
