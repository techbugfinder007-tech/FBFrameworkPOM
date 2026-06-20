Feature: Facebook Login Functionality

  Background:
    Given user is on Facebook login page

  Scenario: Login with valid credentials
    When user enters valid email and password
    And clicks on login button
    Then user should be logged in successfully

  Scenario: Login with invalid credentials
    When user enters invalid email and password
    And clicks on login button
    Then  "Invalid or Incorrect email" message is displayed 
    