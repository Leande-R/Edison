Feature: : Create a new charging station



  Scenario:  Create a new Charging Station in Fürstenfeld
  Given i want to create a new Charging Station in the System
    When i enter "Einsteingasse 1, 8280" into the Location field
    And i enter the name "Fürstenfeld Charging" into the name field

    And i set the price for AC charging to 0.25 per kWh
    And i set the price for DC charging to 0.35 per kWh
    Then i have successfully created a new Charging Station in "Einsteingasse 1, 8280" with the name "Fürstenfeld Charging" and the AC-price  0.25 and the DC-Price 0.35


