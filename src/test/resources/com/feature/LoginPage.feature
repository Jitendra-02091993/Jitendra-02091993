Feature: Validate Login Page
	
	Scenario: To Validate the title of the Login Page
	When user is on login page
	Then validate title is equal to "OrangeHRM"
	
	@Sanity
	Scenario: To Validate login with valid credentials
	When user is on login page
	When user enter username in "Admin"
	When user enter password in "admin123"
	Then user click on loginButton