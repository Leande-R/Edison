Feature: : Successfully creating a new charger

Background:
  Given I already created a charging station in Fürstenfeld called "FürstenfeldCharging"


  Scenario:  Create a new AC charger
    When I assign the charger to the charging station "FürstenfeldCharging"
    And I enter the ID 12345
    And I select the Charging Method as "AC"
    Then a new Charger with the ID 12345 is created
    And it has the Charging Method "AC"
    And it's assigned to the Charging Station "FürstenfeldCharging"


  Scenario: Create a DC Charger
    When I assign the charger to the charging station "FürstenfeldCharging"
    And I enter the ID 54321
    And I select the Charging Method as "DC"
    Then a new Charger with the ID 54321 is created
    And it has the Charging Method "DC"
    And it's assigned to the Charging Station "FürstenfeldCharging"

