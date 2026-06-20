Feature: Facebook Registration Functionality

  Background:
    Given user is on Facebook login page
    When user clicks on Create New Account

  Scenario: Register with valid data
    When user enters valid registration details
    And clicks on Sign Up button
    Then user account should be created successfully


  Scenario: Register with empty fields
    When user clicks on Sign Up without entering data
    Then user should see validation errors
    
    