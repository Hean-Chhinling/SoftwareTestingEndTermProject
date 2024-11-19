Feature: Demoblaze about us

  Background:
    Given the home page is opened

    Scenario: click about us and check if the guidance video is there then close
      Given the about us link is clicked
      And the guidance video is existed
      Then the close button is clicked