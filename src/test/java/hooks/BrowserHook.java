package hooks;

import generic.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

import static generic.DriverFactory.*;

public class BrowserHook {
    @Before
    public void setup() {
        driverInit();
        driver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
   @After
    public void teardown(){
       quit();
    }
}
