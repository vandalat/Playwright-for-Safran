package com.safran.steps;

import com.microsoft.playwright.Page;
import com.safran.pages.AccountPage;
import com.safran.pages.HomePage;
import com.safran.pages.LoginPage;
import com.safran.utilities.ConfigurationReader;
import com.safran.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class HomePageStepDefs {
    Page page=Driver.getInstance().getBrowser().newPage();;
    HomePage homePage;


    @Given("user is on the home page")
    public void user_is_on_the_home_page() {

        homePage=new HomePage(page);
        homePage.navigateTo(ConfigurationReader.getProperty("url"));

    }

    @Then("user should be able to see title {string}")
    public void user_should_be_able_to_see_title(String expectTitle) {

        String actualTitle = homePage.getPage().title();
        System.out.println(actualTitle);

        Assertions.assertEquals(expectTitle, actualTitle);


    }

    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        homePage.getLoginBtn().click();


    }

}
