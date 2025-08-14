Feature: Testing Sign In Page Selenide
  Background:

    Given Set up driver Selenide

  Scenario: Attempt to sign in with empty form Selenide
    When I open the Sign In page Selenide
    And I click the Sign In button Selenide
    Then the email input should be visible Selenide
    And the password input should be visible Selenide
    Then quit driver Selenide

  Scenario: Navigate to the registration page Selenide
    When I open the Sign In page Selenide
    And I click the Registration link Selenide
    Then I should see the Sing in text on the registration page Selenide
    Then quit driver Selenide

  Scenario Outline: Successful login Selenide
    When I open the Sign In page Selenide
    And I fill the login form with email "<email>" and password "<password>" Selenide
    And I click the Sign In button Selenide
    Then the Sign Out button should be visible Selenide
    Then quit driver Selenide
    Examples:
      |email|password|
      |svetatest@gmail.com|Qwerty123|