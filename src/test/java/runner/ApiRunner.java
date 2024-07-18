package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepsdef"},
        features = {"src/test/java/feature"},
        tags = "@api"

)
public class ApiRunner {
}
