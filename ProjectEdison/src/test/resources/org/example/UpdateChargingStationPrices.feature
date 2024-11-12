Feature: Create a Charging Station Price List

  Background:
    Given the fixed Standing Fee is 0.50€ per Minute
    And I want to see the Prices for


  Scenario: Successfully creating a new charging Station price list
    When I select the Charging Station "WienCharging"
    And I set the price for "AC" to "0.29"€ per kWh
    And I set the price for "DC" to "0.37"€ per kWh
    Then the updated price for "AC" is "0.29"€ per kWh
    And the updated price for "DC" is "0,37"€ per kWh
