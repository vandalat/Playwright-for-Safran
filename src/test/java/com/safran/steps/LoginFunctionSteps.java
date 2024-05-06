package com.safran.steps;

import com.microsoft.playwright.Page;
import com.safran.pages.AccountPage;
import com.safran.pages.HomePage;
import com.safran.pages.LoginPage;
import com.safran.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class LoginFunctionSteps {

    Page page = Driver.getInstance().getBrowser().newPage();

    LoginPage loginPage;

    AccountPage accountPage;

    @And("the user is logged in with {string}")
    public void the_user_is_logged_in_with(String submitType) {

        loginPage=new LoginPage(page);
        loginPage.loginByType(submitType);

    }
    @Then("the user should see the url contains {string}")
    public void the_user_should_see_the_url_contains(String endpoint) {
        accountPage=new AccountPage(page);
        Assertions.assertTrue(accountPage.getUrl().contains(endpoint));

    }
    @Then("the user should see the username as {string}")
    public void the_user_should_see_the_username_as(String name) {
        Assertions.assertEquals(name, accountPage.getAcountName());
    }

}
