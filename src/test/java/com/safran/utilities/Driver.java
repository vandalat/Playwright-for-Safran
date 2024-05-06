package com.safran.utilities;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Driver {
    private static Driver instance;
    private final Playwright playwright;
    private final Browser browser;

    private Driver() {
        playwright = Playwright.create();
        BrowserType browserType = null;
        String typeOfBrowser = ConfigurationReader.getProperty("browser");
        switch (typeOfBrowser.toLowerCase()) {
            case "chrome":
                browserType = playwright.chromium();
                break;
            case "firefox":
                browserType = playwright.firefox();
            case "safari":
                browserType=playwright.webkit();
        }

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public Browser getBrowser() {


        return browser;
    }

    public void close() {
        browser.close();
        playwright.close();
    }
}

