
Feature: Login

  Scenario Outline: Successful login
    Given the user is on the login page
    When the user enters the username <valid_user> and the password valid <valid_password>
    And the user clicks the login button
    Then the user should see the home page
    Examples:
      |valid_user|valid_password|
      |"standard_user"|"secret_sauce"|



