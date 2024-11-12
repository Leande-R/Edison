Feature: Create a new customer
Background:
  Given I want to create a new customer

Scenario: Successfully creating a new customer
  When I enter the first name "John"
  And I enter the last name "Doe"
  And I enter the ID of the Customer  47853
  And I enter the email "john.doe@example.com"
  Then a new customer with the first name "John" is added
  And  with the last name "Doe"
  And the ID 47853
  And  the email "john.doe@example.com" is created


Scenario: Attempting to create a customer with an existing email
    When I enter the first name "John"
    And I enter the last name "Doe"
    And I enter the ID of the Customer "47853"
    And I enter the email "john.doe@example.com"
    Then I receive an error message stating "The email address 'john.doe@example.com' is already in use. Please use a different email."
    And the customer account is not created