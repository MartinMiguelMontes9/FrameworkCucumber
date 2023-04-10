
Feature: Blocket User Login


  Scenario Outline: Blocked user login

    Given the user is on the login page
    When the user enters the username <block_user> and the password <block_pass> blocked
    And the user clicks the login button
    Then the user should see an error message about as blocked

    Examples:
      | block_user      | block_pass |
      | "standard_user" | "secret_sauce" |
