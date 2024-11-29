Feature: Demoblaze login

  Background:
    Given the home page is opened

    Scenario Outline: checking welcome username
      Given the 'Log in' button is clicked
      And the log in 'Username:' field is filled with '<username>'
      And the log in 'Password:' field is filled with '<password>'
      And the 'Pop up Login' button is clicked
      Then the user is welcome with '<greeting>'
      Examples:
        | username          | password      | greeting        |
        | admin             | admin         | Welcome admin   |
        | ling              | ling          | Welcome ling    |
        | chin              | chin          | Welcome chin    |
        | long              | long          | Welcome long    |

    Scenario: validate log out functionality
      Given the 'Log in' button is clicked
      And the log in 'Username:' field is filled with 'ling'
      And the log in 'Password:' field is filled with 'ling'
      And the 'Pop up Login' button is clicked
      Then the user is welcome with 'Welcome ling'
      And the 'Log out' button is clicked
      Then the log in button is present

