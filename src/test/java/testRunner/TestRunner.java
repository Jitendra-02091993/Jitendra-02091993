package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/feature"},
		tags = "@Sanity",
		glue = {"stepDefinitions","commonSteps","applicationHook"},
		plugin = {"pretty","com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class TestRunner {

}
