Feature: Assign Charger Status

Background:
  Given I want to assign a different charger status to my charger

  Scenario: Assign a  charger status to my charger
    When My Charger has the Status IN_OPERATION_FREE
    And I want to change its Status to OUT_OF_ORDER
    Then the charger status OUT_OF_ORDER is assigned to the charger
    And no longer IN_OPERATION_FREE


