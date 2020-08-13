package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.HomePage;

import static generic.DriverFactory.*;

public class QATaskFeature {

    public HomePage homePage = HomePage.getInstance();

    @Given("I am on {string} home page")
    public void i_am_on_home_page(String url) {
        get(url);

    }

    @When("I type {string} as App Name")
    public void i_type_as_app_name(String appName) {
       homePage.applicationName.sendKeys(appName);

    }

    @When("I type {string} as Email address")
    public void i_type_as_email_address(String email) {
     homePage.email.sendKeys(email);

    }

    @When("I type {string} as Password")
    public void i_type_as_password(String password) {
        homePage.password.sendKeys(password);
    }

    @When("I click on Sign in button")
    public void i_click_on_sign_in_button() {
       homePage.signInButton.click();

    }

    @Then("I should see my Dashboard")
    public void i_should_see_my_dashboard() {
        String expect = "http://login.myappcms.com/build";
        String actual =  currentURL();
        Assert.assertEquals( expect, actual);


    }


    @Given("I am on {string} page")
    public void iAmOnPage(String url) {
        get(url);
    }

    @When("I click {string} on {string} column")
    public void iClickOnColumn(String sortOrder, String column) {
    }

    @Then("I should see correct results list")
    public void iShouldSeeCorrectResultsList() {
    }

    @When("I type {string} in the Search box")
    public void iTypeInTheSearchBox(String arg0) {
    }
}
