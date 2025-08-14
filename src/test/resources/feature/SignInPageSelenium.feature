Feature: Testing Sign In Page
  Background:

    Given Set up driver

  Scenario: Attempt to sign in with empty form
    When I open the Sign In page
    And I click the Sign In button
    Then the email input should be visible
    And the password input should be visible
    Then quit driver

  Scenario: Navigate to the registration page
    When I open the Sign In page
    And I click the Registration link
    Then I should see the Sing in text on the registration page
    Then quit driver

  Scenario Outline: Successful login
    When I open the Sign In page
    And I fill the login form with email "<email>" and password "<password>"
    And I click the Sign In button
    Then the Sign Out button should be visible
    Then quit driver
    Examples:
      |email|password|
      |svetatest@gmail.com|Qwerty123|