@regression
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann"
    And I enter age: 5
    And I change age to 6
    And I click submit age
    Then I see message: "Hello, Ann, you are an adult"

  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I change name to "Tom"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Tom, you are an adult"
  @part2
    Scenario: Enter a number 1
    Given I am on task page
    When I enter number 35
    And I click submit number
    Then I should see an error: "Number is too small"

