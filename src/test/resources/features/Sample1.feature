@part1
Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    Then I see message: "This is a home page"
    Then I see message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

    
  Scenario: The simplest one
    And I see message: "Pages Examples"
    And I see message: "Locators"
    Then I enter

    
