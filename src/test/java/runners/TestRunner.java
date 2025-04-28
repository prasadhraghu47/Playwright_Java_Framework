package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",           // Correct path: resources folder
        glue = {"steps", "hooks"},                          // No 'src/test/java' prefix needed
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true,
        publish = true,
         tags = "@test" // Uncomment if you want to run specific tags
)
public class TestRunner {
}
