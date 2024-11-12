Feature: : Create a new charging station

Background:
  Given I want to create a new Charging Station in the System
  And the address of the Charging Station is "Einsteingasse 1 8280"

  Scenario:  Create a new Charging Station in Fürstenfeld
    When I enter "Einsteingasse 1, 8280" into the Location field
    And I enter the name "FürstenfeldCharging" into the name field
    And I set the price for "AC" charging to "0.25"€ per minute
    And I set the price for "DC" charging to "0.35"€ per minute
    Then I have successfully created a new Charging Station in "Einsteingasse 1, 8280" with the name "FürstenfeldCharging"
    And I have successfully created a new price list for the Charging Station "FürstenfeldCharging"
    And I have set the price for "AC" to "0.25"€ per minute
    And I have set the price for "DC" to "0.35"€ per minute



