
Feature: : Successfully creating a new charger
Background:
Given I created a new charging station in Fürstenfeld


Scenario:  Create a new charger
Given I want to create a new charger

When I assign the charger to the charging station "Fürstenfeld Charging"
And I enter the ID 12345
  And I select the Charging Method as AC
Then a new Charger with the ID 12345 assigned to the Charging Station "Fürstenfeld Charging" is created
