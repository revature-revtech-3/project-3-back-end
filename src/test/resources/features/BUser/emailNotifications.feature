Feature: Add and view user reviews on a product
  Scenario: User makes purchase and get an email purchase notification 
    
    Given The user is on the product page
    When The user clicks the view details button
    When The user clicks the buy now button
    When The user clicks the proceed to checkout button
   	When The user should see a purchase confirmation
    Then The user should recieve an email 