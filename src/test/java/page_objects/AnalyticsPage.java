package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnalyticsPage {
    @FindBy(className = "social")
    public WebElement socialTab;
    @FindBy(xpath = "//div[contains(text(),'Social Media')]")
    public WebElement socialMediaHeader;
}
