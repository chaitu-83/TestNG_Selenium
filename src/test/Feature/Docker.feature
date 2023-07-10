Feature: To validate Docker Logo  scenario

  Scenario Outline: check Docker logo is present
    Given user launch the Docker website with Url as "<url>"
    Then  user validate logo is present
    And user check Sign in  link present
    And user validate Get Started link
    And user validate the Products dropdown by Hovering it
    And user scroll down to bottom of the page and validate "Accelerate your application development today."
    And user validate all SocialMedia links
    And user close the Docker application


    Examples:

      |url|
      |https://www.docker.com/|
