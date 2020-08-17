package page_objects;

import generic.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BuildPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Appointments')]")
    @CacheLookup
    public WebElement appointmentTab;
    @FindBy(xpath = "//div[contains(text(),'Services')]")
    public WebElement serviceTab;
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchInput;
    @FindBy(xpath = "//tbody[contains(@id,'gridview')]")
    public WebElement table;
    @FindBy(xpath = "//span[text()='Show Fullscreen']/parent::span")
    public WebElement fullScreenButton;
    @FindBy(xpath = "//input[@placeholder='Service Name']")
    public WebElement serviceNameInput;
    @FindBy(xpath = "//span[contains(text(),'Analytics')]")
    public WebElement analyticsTab;


    public void openServiceTab() {
        appointmentTab.click();
        serviceTab.click();
    }

    public void searchForServiceName(String serviceName) {
        openServiceTab();
        searchInput.sendKeys(serviceName,Keys.ENTER);

    }


    public void columnSort(String column, String sortOrder) {
        wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        //"//span[text()=" + column + "][1]"
        String columnXpath = String.format("//span[text()='%s']", column);
        WebElement columnElement = driver.findElement(By.xpath(columnXpath));
        mouseOver(columnElement);

        String popUpXpath = String.format("//span[text()='%s']/following-sibling::div[1]", column);
        driver.findElement(By.xpath(popUpXpath)).click();

        String sortXpath = String.format("//span[text()= '%s']", sortOrder);
        driver.findElement(By.xpath(sortXpath)).click();
    }
    public void clickFullScreenButton(){
        openServiceTab();
       fullScreenButton.click();
    }


}
