
Feature: Create a Charging Station Price List

  Scenario: Successfully creating a new charging Station price list
    When I want to create a new Charging Station price list for my Charging Stations
    And I add my Charging Stations Fürstenfeld Charging, Graz Charging, Wien Charging to the price list
    Then a new charging price list is created
