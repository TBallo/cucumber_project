@regression
Feature: Testing of Form page

  Background:
    Given I am on task page

  Scenario: Checking numbers below 50
    When I enter number below expected
    And I click submit
    Then I see error message that the number is too small

  Scenario: Checking numbers above 100
    When I enter number above expected
    And I click submit
    Then I see error message that the number is too big
