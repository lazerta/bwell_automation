package generic.base;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class BasePage {
    public static WebDriver driver = null;
    public static File cookieFolder = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
            "cookies").toFile();

    public void quit() {
        driver.quit();
    }

    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public void get(String url) {
        driver.get(url);
    }
    public  void sleep(int timeInMillionSecond){
        try {
            Thread.sleep(timeInMillionSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isClickable(WebElement element) {
        try {
            element.click();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }



    public void get(String url, String cookieName) {
        get(url + "/404");
        addAllCookies(cookieName);
        refresh();
        get(url);

    }

    public WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, seconds);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public Actions actions() {
        return new Actions(driver);
    }

    public void mouseOver(WebElement element) {
        actions().moveToElement(element).build().perform();
    }

    public void saveCookie(String fileName) {
        // create cookie folder if not exist
        if (!cookieFolder.exists()) {
            cookieFolder.mkdirs();
        }
        File file = new File(cookieFolder, fileName);
        // remove cookie file if  existed
        if (file.exists()) {
            file.delete();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Cookie cookie : driver.manage().getCookies()) {
                writer.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure()));
                writer.newLine();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addAllCookies(String fileName) {
        File file = new File(cookieFolder, fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException(fileName + " does not exist");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ";");


                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;

                    if (!(val = token.nextToken()).equals("null")) {
                        expiry =     new Date(val);
                    }
                    boolean isSecure = Boolean.parseBoolean(token.nextToken());
                    Cookie cookie = new Cookie(name,
                            value, domain, path, expiry, isSecure);
                    driver.manage().addCookie(cookie);


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
