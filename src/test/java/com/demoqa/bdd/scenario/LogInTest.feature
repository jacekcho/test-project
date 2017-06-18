Feature: Login Page

  Scenario: Successful Login with correct data
    Given user is on home page
    When user navigate to login page
    And user entered login jacektest
    And user entered password QW12qw12
    When user click log in button
    Then user logged as: jacektest

  Scenario: Successful Log Out
    Given user is on home page
    When user navigate to login page
    And user logs on
    When user log out from the application
    Then user is logged out

  Scenario Outline: Validate wrong credentials
    Given user is on home page
    When user navigate to login page
    And user entered login <login>
    And user entered password <password>
    When user click log in button
    Then user get invalid login credentials

    Examples:
      | login      | password      |
      | jacektest  | wrongPassword |
      | wrongLogin | QW12qw12      |
