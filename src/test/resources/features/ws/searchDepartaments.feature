Feature: Search departaments
  @SmokeTest
  Scenario Outline: Successfully searching for apartments.
    Given I make a GET request to url
    Then The response status code should be <code>
    And The response should contain the key <result>
    And The <result> field should not be empty

    Examples:
      | code      |result |
      | 200 | "departments" |