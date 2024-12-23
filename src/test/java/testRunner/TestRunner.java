package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/com/feature" }, // Ensure the path to feature files is correct
		tags = "@Sanity", // Tags to filter scenarios
		glue = { "stepDefinitions", "commonSteps", "applicationHook", "testData" }, // Packages containing step
																					// definitions
//		monochrome = true, // Set to true for better console output (optional)
//		dryRun = false, // Set to false to execute tests; true for checking undefined steps
		plugin = { "pretty", // Pretty console output
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent Reports adapter
		})
public class TestRunner {
}
