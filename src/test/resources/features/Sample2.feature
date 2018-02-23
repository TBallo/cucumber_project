@regression
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann"
    And I enter age: 5
    And I changed age to: 6
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I changed name to: "Tom"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"
  @part2
  Scenario: Enter a number 1
    Given Iam on task page
    And I enter number: 35
    Then I should see an error: "number is too small"