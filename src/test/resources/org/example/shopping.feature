Feature: Demoblaze shopping

  Background:
    Given the home page is opened

    Scenario Outline: Checking item price
      Given the '<item>' link is clicked
      Then the '<price>' is displayed
      Examples:
        | item                        | price              |
        | Samsung galaxy s6           | $360 *includes tax |
        | Nokia lumia 1520            | $820 *includes tax |
        | Nexus 6                     | $650 *includes tax |
        | Samsung galaxy s7           | $800 *includes tax |
        | Iphone 6 32gb               | $790 *includes tax |
        | Sony xperia z5              | $320 *includes tax |

    Scenario Outline: Checking the same product name is displayed in product detail page
      Given the '<item>' link is clicked
      Then the product '<title>' is displayed
      Examples:
        | item                  | title                   |
        | Samsung galaxy s6     | Samsung galaxy s6       |
        | Nokia lumia 1520      | Nokia lumia 1520        |
        | Nexus 6               | Nexus 6                 |
        | Samsung galaxy s7     | Samsung galaxy s7       |

    Scenario: Checking the item title of the next page
      Given the next page button is clicked
      Then the home product 'Apple monitor 24' is displayed


    Scenario: Add Samsung galaxy s7 and Iphone 6 32gb then check the total price
      Given the 'Samsung galaxy s7' item is clicked
      And the 'Add to cart' add to cart button is clicked
      And the 'Home' button is clicked
      And the 'Iphone 6 32gb' item is clicked
      And the 'Add to cart' add to cart button is clicked
      And the 'Cart' button is clicked
      Then the price should read '1590'

    Scenario Outline: Check product description
      Given the '<item>' link is clicked
      Then the product description contains '<description>'
      Examples:
        | item                  | description                                                 |
        | Samsung galaxy s7     | 1.6GHz octa-core it comes with 4GB of RAM                   |
        | Iphone 6 32gb         | Apple iPhone 6 packs a 8-megapixel                          |
        | Sony xperia z5        | resolution of 1080 pixels by 1920 pixels                    |
        | Nokia lumia 1520      | 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 |



