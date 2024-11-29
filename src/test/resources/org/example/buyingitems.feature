Feature: Demoblaze buying items

  Background:
    Given the home page is opened

  Scenario: Buying a Samsung galaxy s6 and Nokia lumia 1520
    Given the 'Samsung galaxy s6' item is clicked
    And the 'Add to cart' add to cart button is clicked
    And the 'Home' button is clicked
    And the 'Nokia lumia 1520' item is clicked
    And the 'Add to cart' button is clicked
    And the 'Cart' button is clicked
    And the price should read '1180'
    And the 'Place Order' button is clicked
    And the 'Name:' field is filled with 'Chhinling'
    And the 'Country:' field is filled with 'Cambodia'
    And the 'City:' field is filled with 'Phnom Penh'
    And the 'Credit card:' field is filled with '1290309293'
    And the 'Month:' field is filled with 'May'
    And the 'Year:' field is filled with '2024'
    And the 'Purchase' button is clicked

  Scenario: Add Nokia lumia 1520 and Nexus 6 then delete Nexus 6 and check the total price
    Given the 'Nokia lumia 1520' item is clicked
    And the 'Add to cart' add to cart button is clicked
    And the 'Home' button is clicked
    And the 'Nexus 6' item is clicked
    And the 'Add to cart' add to cart button is clicked
    And the 'Cart' button is clicked
    And the 'Delete Nexus Item' button is clicked
    Then the price should read '820'
