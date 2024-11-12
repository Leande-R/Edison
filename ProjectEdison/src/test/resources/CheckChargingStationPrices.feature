Feature: Check Charging Station Prices

Background:
  Given The Charging Stations "WienCharging", "GrazCharging" and "LinzCharging" are already created
  And the Standing Fee is "0.50"€ per minute on every Charging Station
  And the Price for "AC" at "WienCharging" is "0.25"€ per KwH
  And the Price for "DC" at "WienCharging" is "0.40"€ per KwH
  And the Price for "AC" at "GrazCharging" is "0.30"€ per KwH
  And the Price for "DC" at "GrazCharging" is "0.38"€ per KwH
  And the Price for "AC" at "LinzCharging" is "0.28"€ per KwH
  And the Price for "DC" at "LinzCharging" is "0.43"€ per KwH


  Scenario: Successfully checking the prices of the existing charging station
    When I open the Pricelists of the three Stations to compare them
    Then I see that the Standing Fee on all Charging Stations is "0.50"€ per minute
    And I see that the Price for "AC" at "WienCharging" is "0.25"€ per KwH
    And I see that the Price for "DC" at "WienCharging" is "0.40"€ per KwH
    And I see that the Price for "AC" at "GrazCharging" is "0.30"€ per KwH
    And I see that the Price for "DC" at "GrazCharging" is "0.38"€ per KwH
    And I see that the Price for "AC" at "LinzCharging" is "0.28"€ per KwH
    And I see that the Price for "DC" at "LinzCharging" is "0.43"€ per KwH