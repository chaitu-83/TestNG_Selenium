Feature: User validate Google Application


    @Smoke
    Scenario:validate Google Home page
    Given User launch Google URL
    Then user see google logo
    And user validate title as Google
    When user type Automation testing in Google search box
    Then user see Search result
    Then user close the application
