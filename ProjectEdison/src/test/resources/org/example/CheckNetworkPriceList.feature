Feature: Check Charging Station Prices

  Scenario: Successfully checking the prices of the existing charging station
    Given I plan to charge my vehicle
    When I check the Network-Pricelist of the charging stations "WienCharging", "GrazCharging", "LinzCharging"
    Then I can see the prices of the charging stations