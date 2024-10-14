package stepDefinitions;
import static org.testng.Assert.assertEquals;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.CommonStepsAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	CommonStepsAction action = new CommonStepsAction(DriverFactory.getDriver());
		
	@Then("validate title is equal to {string}")
	public void validate_title_is_equal_to(String value) {
		String expectedTtitle = loginPage.getTitle();
		assertEquals(value, expectedTtitle);
	}
//
//	@When("user enter username in {string}")
//	public void user_enter_username_in(String value) {
//	    loginPage.
//	}
//
//	@When("user enter password in {string}")
//	public void user_enter_password_in(String value) {
//		loginPage.enterText(value);
//	}
//
	@Then("user click on loginButton")
	public void user_click_on_loginButton(String ele) {
		action.clickElement(ele);
	}

}
