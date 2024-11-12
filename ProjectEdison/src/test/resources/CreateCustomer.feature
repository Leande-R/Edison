Feature: Create a new customer

Background:
  Given I want to create a new Account
  And my name is "John Doe"

  Scenario: Successfully creating a new customer
    When I enter the name "John Doe"
    Then a new Customer is created
    And the Customer name is "John Doe"
    And the Credit is "0.00"€