package com.safran.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.safran.utilities.Driver;
import lombok.Getter;

@Getter
public class HomePage {


    private final Locator loginBtn;
    private final Page page;


    public HomePage(Page page) {
        this.page =page;

        this.loginBtn= Driver.getInstance().getBrowser().newPage().locator("text=Login");
    }

    public void navigateTo(String url) {

        page.navigate(url);

    }



    public  Page getPage(){

        return page;
    }














}






