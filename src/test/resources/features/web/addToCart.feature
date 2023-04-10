Feature: Adding products to the shopping cart

  Scenario Outline: Add a product to the cart while logged in
    Given the user is logged in whit a valid user <valid_user> and pass <valid_password>
    And the user is on the product page
    When the user clicks on the Add to Cart button
    Then the product should be added to the shopping cart


    Examples:
      | valid_user      | valid_password |
      | "standard_user" | "secret_sauce" |