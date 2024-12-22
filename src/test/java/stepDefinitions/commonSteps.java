package stepDefinitions;

import java.io.IOException;
import com.qa.factory.DriverFactory;
import com.qa.utils.CommonStepsAction;
import com.qa.utils.Log;
import com.qa.utils.globalVar;
import com.qa.utils.xlsUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class commonSteps {
	private CommonStepsAction action = new CommonStepsAction(DriverFactory.getDriver());
	public globalVar global = new globalVar();
	public xlsUtils utils = new xlsUtils();
	private static final Logger logger = LogManager.getLogger(commonSteps.class);


	@Given("user launch the url")
	public void user_launch_the_url() {
		action.launchUrl();
		logger.info("URL is launched");
	}

	@When("user enter \"(.*)\" in \"([^\"]*)\"$")
	public void user_enter_in(String value, String ele) {
		action.enterText(value, ele);
		logger.info(value+" text is entered in "+ele);
	}

	@When("user enter {string} in {string} from testData")
	public void user_enter_in_from_test_data(String value, String ele) throws IOException {
		Log.info("Value from excel sheet is ===> " + xlsUtils.getValue(value));
		action.enterText(xlsUtils.getValue(value), ele);
	}

	@Then("user click on \"(.*)\"$")
	public void user_click_on(String ele) {
		action.clickElement(ele);
		logger.info("Clicked on => "+ele);
	}

	@Then("user wait for \"(.*)\" seconds$")
	public void user_wait_for_seconds(String value) throws Exception {
		action.waitTime(value);
	}

	@Given("test data file is {string}")
	public void test_data_file_is(String testDataFullPath) {
		System.out.println("value is " + testDataFullPath);
		globalVar.globalTestDataFile = testDataFullPath;
		System.out.println("Test Data file is " + globalVar.globalTestDataFile);
	}

	@And("print number of sheets in workBook {string}")
	public void print_number_of_sheets_in_workBook(String testDataFullPath) {
		System.out.println(testDataFullPath);
		int totalCount = xlsUtils.getWorksheetCount(testDataFullPath);
		System.out.println("totalCount of Sheets in " + testDataFullPath + "workBook " + "is " + totalCount);
	}

	@Then("verify below elements are visible")
	public void verifyBelowElementsAreVisible(DataTable dataTable) {
		action.testDataTableVerification(dataTable);
	}

}
