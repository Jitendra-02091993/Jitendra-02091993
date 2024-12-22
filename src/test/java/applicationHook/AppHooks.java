package applicationHook;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.Log;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;
	private static final Logger logger = LogManager.getLogger(AppHooks.class);

    @Before(order = 0)
    public void loadProperties() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void initializeBrowser() {
//    	log = LogManager.getLogger(this.getClass().getName());
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browserName);
        logger.info("Browser Initialized");
//        Log.startTestCase("Test-----------");
    }
    

    @After(order = 0)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("driver is closed");
        }
    }

    @After(order = 1)
    public void captureScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", screenshotName);
        }
    }

    // Optionally, provide a method to get the WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }
}
