Feature: Demoblaze contact

  Background:
    Given the home page is opened

    Scenario: Send a contact us message
      Given the contact link is clicked
      And the contact 'Contact Email:' field is filled with 'ling@gmail.com'
      And the contact 'Contact Name:' field is filled with 'Ling'
      And the contact 'Message:' field is filled with 'I want to buy new Iphone'
      And the send message button is clicked