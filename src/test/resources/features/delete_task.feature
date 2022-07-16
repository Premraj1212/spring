@delete @regression @e2e
Feature: Delete task in the application
  In order to keep task updated in the application
  As a user
  I should be able to delete my task

  Background:
    Given user has logged onto the application

  Scenario: User is able to delete task
    Given user todo list is empty
    When user adds following tasks:
      |to go for swim|
      |play games    |
      |fly high      |
    And user delete a task: fly high
    Then user should see all task listed in the application:
      |to go for swim|
      |play games    |

