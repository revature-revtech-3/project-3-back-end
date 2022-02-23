Feature: The user should be able to add items to cart
  Scenario: As a user, I should be able to add items to my cart that I will later purchase or remove from my cart
    Given The user is on the home page
    When The user clicks on the view details button
    When The user is redirected to the product page
    When The user clicks on the + icon
    When The user clicks on go to cart button
    Then The user is redirected to the checkout page