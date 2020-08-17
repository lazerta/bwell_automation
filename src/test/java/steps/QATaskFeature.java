package steps;

import generic.po.TablePO;
import generic.base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.AnalyticsPage;
import page_objects.BuildPage;
import page_objects.HomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;


public class QATaskFeature extends BasePage {

    public HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    public BuildPage buildPage = PageFactory.initElements(driver, BuildPage.class);
    public AnalyticsPage analyticsPage = PageFactory.initElements(driver, AnalyticsPage.class);


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
        String expected = "http://login.myappcms.com/build";
        wait(10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("main-title")));
        String actual = currentURL();

        assertThat(actual, is(expected));

        saveCookie("cookie.data");

    }


    @Given("I am on {string} page")
    public void iAmOnPage(String url) throws InterruptedException {
        get(url, "cookie.data");


    }

    @When("I click {string} on {string} column")
    public void iClickOnColumn(String sortOrder, String column) {

        buildPage.openServiceTab();
        buildPage.columnSort(column, sortOrder);

    }


    @Then("I should see correct results list")
    public void iShouldSeeCorrectResultsList() {
        sleep(2000);
        TablePO tablePO = new TablePO(buildPage.table);
        List<String> actual = tablePO.getColDataList(0);

        List<String> expected = new ArrayList<>(actual);


        expected.sort(String::compareToIgnoreCase);


        Assert.assertEquals(expected, actual);


    }


    @When("I type {string} in the Search box")
    public void iTypeInTheSearchBox(String serviceName) {

        buildPage.searchForServiceName(serviceName);


    }


    @Then("I should see Add page display")
    public void iShouldSeeAddPageDisplay() {
        wait(5).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Services']")));

    }

    @Then("I should see correct results list that elements start with {string}")
    public void iShouldSeeCorrectResultsListThatElementsStartWith(String startWith) {
        sleep(2000);
        TablePO tablePO = new TablePO(buildPage.table);
        List<String> actual = tablePO.getColDataList(0);
        boolean isMatch = actual.stream().allMatch(s -> s.startsWith("colour"));
        Assert.assertTrue(isMatch);
    }

    @When("I click on full screen button")
    public void iClickOnFullScreenButton() {
        buildPage.clickFullScreenButton();


    }

    @Then("I should see  page display in full screen mode")
    public void iShouldSeePageDisplayInFullScreenMode() {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Services')]"));

        boolean clickable = isClickable(element);
        Assert.assertFalse(clickable);

    }

    @When("I click Analytics tab")
    public void iClickAnalyticsTab() {
        buildPage.analyticsTab.click();


    }

    @Then("I should be on {string}")
    public void iShouldBeOn(String expected) {
        String actual = currentURL();
        assertThat(actual, is(expected));

    }

    @When("I click Social Media tab")
    public void iClickSocialMediaTab() {
        analyticsPage.socialTab.click();


    }

    @Then("social media statistic board should display")
    public void socialMediaStatisticBoardShouldDisplay() {
        wait(1).until(ExpectedConditions.visibilityOf(analyticsPage.socialMediaHeader));
        Assert.assertTrue(analyticsPage.socialMediaHeader.isDisplayed());
    }
}
