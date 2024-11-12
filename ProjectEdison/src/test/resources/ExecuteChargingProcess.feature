Feature: Execute Charging process

Background:
  Given I want to charge my vehicle at the Charging Station "WienCharging"
  And I already have an account with the ID "47853"
  And my credit is 50€
  And I want to charge my vehicle for 100 minutes
  And I want to charge my vehicle with AC
  And the price for AC at "WienCharging" is 0.25€ per minute

  Scenario: Successfully executing a charging process
    When I select the Charger with the ID 12345 , at the Charging Station "WienCharging"
    And the charging process starts at "2024-10-01T10:00:00"
    And the charging process ends at "2024-10-01T11:40:00"
    Then the charging process took 100 minutes
    And I am charged 50 Euros

    ##----------------------------------------------
  #error case 1: charging process starts before the current time
    Scenario: Charging process starts before the current time
        When the charging process starts at "2024-10-01T09:00:00"
        And the charging process ends at "2024-10-01T08:40:00"
        Then the charging process cannot start before the current time
        And I am not charged

        ##----------------------------------------------