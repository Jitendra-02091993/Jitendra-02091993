Feature: Validate Login Page

  Background: Pre-Requisite
    Given user launch the url

  @Sanity
  Scenario: To Validate login with valid credentials
    Given test data file is "PracticeTest.xlsx"
    Then validate title is equal to "OrangeHRM"
    Then verify below elements are visible
      | usernameInputTextBox        |
      | passwordInputTextBox        |
      | forgetPasswordLinkText      |
    When user enter "Generic.FirstName.Value1" in "usernameInputTextBox" from testData
    When user enter "admin123" in "passwordInputTextBox"
    Then user wait for "2" seconds
    Then user click on "loginButton"
    When user wait for "2" seconds
    Then verify below elements are visible
      | invalidCredentialsErrorText |
    

  @Sanity
  Scenario: To Validate login with in-valid credentials
    Given test data file is "PracticeTest.xlsx"
    When user enter "admin123" in "passwordInputTextBox"
    When user enter "admin123" in "passwordInputTextBox"
    Then user wait for "2" seconds
    Then user click on "loginButton"
    When user wait for "2" seconds
    #Then verify below elements are visible
      #| invalidCredentialsErrorText |
