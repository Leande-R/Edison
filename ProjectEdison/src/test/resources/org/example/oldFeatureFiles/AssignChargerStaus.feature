Feature: Assign Charger Status

  Background:
    Given I want to assign a different charger status to my charger

    Scenario: Assign a  charger status to my charger
       When I enter OUT_OF_ORDER into the charger status description field
      Then the charger status OUT_OF_ORDER is assigned to the charger










