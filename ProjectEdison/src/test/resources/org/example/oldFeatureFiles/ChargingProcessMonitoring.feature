Feature: Charging Process Monitoring
Background:

  Given My Name is "Joe" , "Doe" , CustomerID 6789 , my mail is "joe.doe@example.com", my credit is 50 Euro I just charged my vehicle



  When I was at the charging Station "WienCharging", at the address "Wien 1010, Stephansplatz 1", with a ACPrice of 0.25 Euro per minute , a DCPrice of 0.50 Euro per minute
  And I selected the charger with the ID 12345 , at the chargingstation "WienCharging" , the selected Charging Method is AC
  And the charging process started at "2024-10-01T10:00:00"
  Then  the charging process was executed , took 100 minutes
  And I was charged 25 Euros



  Scenario: Successfully viewing an invoice

  Then I can view the invoice for the charging process