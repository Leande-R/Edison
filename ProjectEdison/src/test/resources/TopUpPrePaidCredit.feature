Feature: Top Up Prepaid Credit

Background:
  Given I have an account
  And I want to top up my credit by 50€

  Scenario: Successfully topping up my prepaid credit
    When I enter the top-up amount 50€
    Then my prepaid account is topped up by 50€