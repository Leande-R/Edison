Feature: Execute Charging process

  Scenario: Successfully executing a charging process
    Given My Name is "Joe" , "Doe" , CustomerID 6789 , my mail is "joe.doe@example.com", my credit is 50 Euro I want to charge my vehicle
    When I am at the chargingstation "WienCharging", at the address "Wien 1010, Stephansplatz 1", with a ACPrice of 0.25 Euro per minute , a DCPrice of 0.50 Euro per minute
    And I select the charger with the ID 12345 , at the chargingstation "WienCharging" , the selected Charging Method is AC
    And the charging process starts at "2024-10-01T10:00:00"
    Then  the charging process is executed , takes 100 minutes
    And I am charged 25 Euros





