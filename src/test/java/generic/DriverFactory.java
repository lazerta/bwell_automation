package generic;

import generic.listeners.BasicWebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class DriverFactory {
    private static  WebDriver webDriver;

    public static  void driverInit(){

        WebDriverManager.chromedriver().setup();

        webDriver = new EventFiringWebDriver(new ChromeDriver())
        .register(new BasicWebDriverListener());


    }

    public static WebDriver driver(){
        return webDriver;
    }
    public static  void quit(){
        webDriver.quit();
    }
    public static  String currentURL(){
    return   webDriver.getCurrentUrl();
    }
    public static  void get(String url){
        webDriver.get(url);
    }


}
