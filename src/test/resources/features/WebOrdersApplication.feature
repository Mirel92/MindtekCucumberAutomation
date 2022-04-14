Feature: Validating WebOrders application login functionality

  Scenario: Validating login functionality with valid credentials
    Given user navigates to weborders application
    When user provides username "Tester" and password "test"
    Then user validates application is logged in


    Scenario: Validating login functionality with invalid credentials
      Given user navigates to weborders application
      When user provides username "testing" and password "Tester123"
      Then user validates error message "Invalid Login or Password."