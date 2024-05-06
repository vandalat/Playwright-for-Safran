package com.safran.test;

import com.microsoft.playwright.*;
import com.safran.utilities.ConfigurationReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class LoginFunction {
    @Test
    void test() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate(ConfigurationReader.getProperty("url"));
        page.click("text=Login");
        page.fill("#edit-name", ConfigurationReader.getProperty("username"));
        page.fill("#edit-pass", ConfigurationReader.getProperty("password"));
        page.click("text=Log in");
        page.waitForTimeout(5000);
        Assertions.assertEquals("Candidate Area | Safran", page.title());
        System.out.println(page.title());

        page.close();
        browser.close();
        playwright.close();
    }
}
