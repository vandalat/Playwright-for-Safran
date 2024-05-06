package com.safran.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;

public class BrowserUtils {
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {

        }
    }

    public static void sleepWithPage(Page page, int second) {
        page.waitForTimeout(second*1000);
    }

    public static void login(Page page, String usernameLocator,String passwordLocator, String userName, String passWord,String sunmitBtn) {
        page.locator(usernameLocator).fill(userName);
        page.locator(passwordLocator).fill(passWord);

        page.locator(sunmitBtn).click();


    }

    public static void clickToText(Page page, String text) {
        page.click(text);
    }
    public static void waitForInvisibilityOfElement(Locator locator){
        locator.elementHandle().waitForElementState(ElementState.HIDDEN);
    }

}


