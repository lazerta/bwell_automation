package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(tags = "@web", features = "src/test/resources/features",
        glue = {"steps"},
        monochrome = true,
        plugin = {
                "html:target/cucumber-report/cucumber_web.html"
        }
)
@RunWith(Cucumber.class)
public class JunitRunner {
}
