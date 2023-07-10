Feature: To validate Infyni SignIn scenario

  Scenario Outline: Signup scenario with multiple data combination
    Given user launch infyni application with URL as "<url>"
    Then  user navigate to signup page
    And user see Header as all fields are mandatory
    And user fill First Name as "<Fname>"
    And user fill Last Name as "<Lname>"
    And  user fill email address as "<EmailAddress>"
    And user fill password as "<Pword>"
    And user fill confirm password as "<CPword>"
    And user close the infyni application


    Examples:

    |url|Fname|Lname|EmailAddress|Pword|CPword|
    |https://infyni.com/|john|khan|abc@gmail.com|1234|1234|
    |https://infyni.com/|sai|kalifa|abc@gmail.com|3456|3456|
    |https://infyni.com/|cohen|john|abc@gmail.com|5678|5678|
    |https://infyni.com/|mike|rick|abc@gmail.com|2345|2345|
    |https://infyni.com/|sony|kaffle|abc@gmail.com|8976|8976|



