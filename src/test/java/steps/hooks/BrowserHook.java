package steps.hooks;


import generic.base.BasePage;
import generic.listeners.web.BasicWebDriverListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;


public class BrowserHook extends BasePage {
    // @BeforeClass
    // public static void setupReport() {
    //     ExtentProperties extentProperties = ExtentProperties.INSTANCE;
    //     extentProperties.setReportPath("output/myreport.html");
    // }
    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver(options))
                .register(new BasicWebDriverListener());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()){
            System.err.println(scenario.getName()+" failed");
        }
        quit();
    }

}
