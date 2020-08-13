package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static generic.DriverFactory.driver;

public class BuildPage {
    @FindBy(xpath = "//div[contains(text(),'Appointments')]")
    @CacheLookup
    public WebElement appointmentTab;
    @FindBy(xpath = "//div[contains(text(),'Services')])")
    public WebElement serviceTab;
    @FindBy(xpath = "textfield-1455-inputEl")
    public  WebElement searchInput;
    private static  BuildPage page;
    private BuildPage() {
        PageFactory.initElements(driver(), this);
    }

    public static BuildPage getInstance() {
        if (page == null){
            page = new BuildPage();
        }
        return  page;
    }

    public void openServiceTab(){
        appointmentTab.click();
        serviceTab.click();
    }

    public  void searchForServiceName(String serviceName){
        openServiceTab();
        searchInput.sendKeys(serviceName);
        searchInput.sendKeys(Keys.ENTER);
    }

}
