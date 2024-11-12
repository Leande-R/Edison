Feature: Charging Process Monitoring

Background:
  Given My Customer Name is "John Doe"
  And my credit is 50 €
  And my vehicle has a maximum Battery capacity of 100 kW
  And the current capacity is at 50 kW
  And I was at the charging Station "WienCharging"
  And the station is located at the address "Wien 1010, Stephansplatz 1"
  And the Price for AC at "WienCharging" is 0.25€ per KwH
  And the Price for DC at "WienCharging" is 0.40€ per KwH
  And the Standing fee is 0.50€ per minute
  And the charging process started at "2024-10-01T10:00:00"
  And the charging process ended at "2024-10-01T11:00:00"



  Scenario: Successfully viewing an invoice after AC Charging
    When I view the invoice
    And I see the rate for "AC" charging is "0.25"€ per kWh
    And I see the total cost for energy consumed is "2.75"€
    And I see the charging station name "WienCharging"
    And I see the location "Wien 1010, Stephansplatz 1"
    And I see that the charging process started at "2024-10-01T10:00:00"
    And I see that the charging process ended at "2024-10-01T11:00:00"
    And I see that the duration of the charging session was "60" minutes


