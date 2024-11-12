Feature: Manage and display charging stations

  Background:
    Given the network contains the charging stations "WienCharging", "GrazCharging", and "LinzCharging"

  Scenario: Display the stations in the order of creation
    When I view the list of charging stations
    Then the stations should be displayed in the following order:
      | WienCharging |
      | GrazCharging |
      | LinzCharging |

  Scenario: Change the AC and DC prices and then display the stations sorted by DC price
    When I update the AC price for "GrazCharging" to 0.32
    And I update the DC price for "GrazCharging" to 0.38
    And I update the AC price for "LinzCharging" to 0.28
    And I update the DC price for "LinzCharging" to 0.45
    Then the updated prices should be:
      | GrazCharging | 0.32 | 0.38 |
      | LinzCharging | 0.28 | 0.45 |
      | WienCharging | 0.25 | 0.40 |