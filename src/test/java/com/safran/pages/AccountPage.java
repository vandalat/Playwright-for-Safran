package com.safran.pages;

import com.microsoft.playwright.Page;
import com.safran.utilities.Driver;
import lombok.Getter;

@Getter
public class AccountPage {

    private final String acountName;
    private final String url;
    private final Page page;


    public AccountPage(Page page) {
        this.page = page;
        this.url = Driver.getInstance().getBrowser().newPage().locator(".visually-hidden.focusable").getAttribute("href");
        this.acountName = Driver.getInstance().getBrowser().newPage().locator("//a[contains(.,'van.sdet')]").textContent();

    }
}
