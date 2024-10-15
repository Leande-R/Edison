Feature: Create a new customer


Scenario: Successfully creating a new customer
Given I want to create a new customer
When I enter the first name "John"
And I enter the last name "Doe"
And I enter the ID of the Customer  47853
And I enter the email "john.doe@example.com"
Then a new customer with the first name "John", last name "Doe", ID 47853 and email "john.doe@example.com" is created