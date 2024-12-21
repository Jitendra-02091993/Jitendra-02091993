package stepDefinitions;
import com.qa.factory.DriverFactory;
import com.qa.utils.CommonStepsAction;
import com.qa.utils.globalVar;
import com.qa.utils.xlsUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class commonSteps {
	private CommonStepsAction action = new CommonStepsAction(DriverFactory.getDriver());
	public globalVar global = new globalVar(DriverFactory.getDriver());
	public xlsUtils utils = new xlsUtils(DriverFactory.getDriver());
	
	
	@Given("user launch the url")
	public void user_launch_the_url() {
		action.launchUrl();
	}
	
	@When("user enter \"(.*)\" in \"([^\"]*)\"$")
	public void user_enter_in(String value, String ele) {
		action.enterText(value, ele);
	}
	
	@Then("user click on \"(.*)\"$")
	public void user_click_on(String ele) {
		action.clickElement(ele);
	}
	
	@Then("user wait for \"(.*)\" seconds$")
	public void user_wait_for_seconds(String value) throws Exception {
		action.waitTime(value);
	}
	
	@Given("test data file is {string}")
	public void test_data_file_is(String testDataFullPath) {
		System.out.println("value is "+testDataFullPath);
		globalVar.globalTestDataFile = testDataFullPath;
		System.out.println("Test Data file is "+globalVar.globalTestDataFile);
	}
	
	@And("print number of sheets in workBook {string}")
	public void print_number_of_sheets_in_workBook(String testDataFullPath) {
		System.out.println(testDataFullPath);
		int totalCount = xlsUtils.getWorksheetCount(testDataFullPath);
		System.out.println("totalCount of Sheets in "+testDataFullPath+"workBook "+"is "+totalCount);
	}

}
