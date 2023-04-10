Feature: Removing products from the shopping cart

  Scenario Outline: Remove a product from the cart while logged in
    Given the user is logged in whit a valid user <valid_user> and pass <valid_password>
    And the user is on the product page
    When the user clicks on the Add to Cart button
    And the product should be added to the shopping cart
    When the user clicks on the Remove button for a specific product
    Then the product should be removed from the shopping cart


    Examples:
      | valid_user      | valid_password |
      | "standard_user" | "secret_sauce" |