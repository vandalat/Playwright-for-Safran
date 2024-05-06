package com.safran.pages;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.safran.utilities.ConfigurationReader;
import com.safran.utilities.Driver;
import lombok.Getter;

@Getter
public class LoginPage {
    private final Locator email;
    private final Locator password;
    private final Locator submitBtn;
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
        this.email= Driver.getInstance().getBrowser().newPage().locator( "#edit-name");
        this.password = Driver.getInstance().getBrowser().newPage().locator("#edit-pass");
        this.submitBtn=Driver.getInstance().getBrowser().newPage().locator("text=Log in");

    }

    public void login(String emailInput, String passwordInput) {
        email.fill(emailInput);
        password.fill(passwordInput);
        submitBtn.click();

    }
    public void loginByType(String submitType){

        if (submitType.equals("submitButton")){
            email.fill(ConfigurationReader.getProperty("username"));
           password.fill(ConfigurationReader.getProperty("password"));
            submitBtn.click();
        }
        if (submitType.equals("enterKey")){
           email.fill(ConfigurationReader.getProperty("username"));
           password.fill(ConfigurationReader.getProperty("password"));
            Keyboard keyboard = Driver.getInstance().getBrowser().newPage().keyboard();
            keyboard.press("Enter");
        }
    }
}
