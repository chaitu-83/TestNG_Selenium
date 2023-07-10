Feature: To open infyni website and navigating to some options
  Scenario Outline: Launch infyni website and validate logo,checkbox

Given user launch infyni Website "<url>"
Then user validate infyni Logo
When user click on LogIn Button
Then user navigate to SignIn page
And validate remember me check box is not checked by default
Then user input incorrect "<userID>" and "<password>"
And user see error message says invalid credentials
Then user clicks on don't have a account SingUp link
And user successfully navigated to SignUp page

    Examples:
    |url|userID|password|
    |https://infyni.com/|abc@gmail.com|2345|