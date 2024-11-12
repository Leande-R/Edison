Feature: Check Charging Station Prices
Background:
  Given I plan to charge my vehicle

  Scenario: Successfully checking the prices of the existing charging station
    When I check the Network-Pricelist of the charging stations "WienCharging", "GrazCharging", "LinzCharging"
    Then I can see the prices of the charging stations