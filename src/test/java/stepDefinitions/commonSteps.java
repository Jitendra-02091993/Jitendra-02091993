package stepDefinitions;
import com.qa.factory.DriverFactory;
import com.qa.utils.CommonStepsAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class commonSteps {
	private CommonStepsAction action = new CommonStepsAction(DriverFactory.getDriver());
	
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

}
