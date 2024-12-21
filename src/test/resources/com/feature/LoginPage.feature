Feature: Validate Login Page
Background: Pre-Requisite
	Given user launch the url
	
	Scenario: To Validate the title of the Login Page
	Then validate title is equal to "OrangeHRM"
	
	@Sanity
	Scenario: To Validate login with valid credentials
	When user enter "Admin" in "usernameInputTextBox"
	When user enter "admin123" in "passwordInputTextBox"
	Then user wait for "2" seconds
	Then user click on "loginButton"
	When user wait for "2" seconds
	Given test data file is "PracticeTest.xlsx"
  Then print number of sheets in workBook "PracticeTest.xlsx"