@liveGuru
Feature: Login to System

  Scenario: Login with empty email and password
    Given I open live guru application
    When Click to My Account page
    And Input to email textbox with ""
    And Input to password textbox with ""
    And Click to Login button
    Then Verify error message displayed at email textbox
    And Verify error message displayed at password textbox
    And Quit application
