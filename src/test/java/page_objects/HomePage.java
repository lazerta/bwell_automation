package page_objects;


import generic.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends BasePage {
    @FindBy(id = "appName")
    @CacheLookup
    public WebElement applicationName;
    @CacheLookup
    @FindBy(id = "username")
    public WebElement email;
    @CacheLookup
    @FindBy(id = "password")
    public WebElement password;
    @CacheLookup
    @FindBy(id = "login-submit")
    public WebElement signInButton;




}
