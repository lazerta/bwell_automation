package page_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static generic.DriverFactory.*;


public class HomePage {
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
    private static  HomePage page;
    private HomePage() {
       PageFactory.initElements(driver(), this);
    }

    public static HomePage getInstance() {
        if (page == null){
            page = new HomePage();
        }
        return  page;
    }
}
