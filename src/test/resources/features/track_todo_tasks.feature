@status
Feature: Track tasks in the application
  In order to track my task added in the application
  As a user
  I should be able to track my task based on its status

  Background:
    Given user has logged onto the application

  Scenario: User is able track the task based on status
    Given user todo list is empty
    When user adds following tasks:
      |to go for swim|
      |play games    |
      |fly high      |
    And user complete a task: fly high
    Then user should able to view the task by status:
      |All           |Completed|Active        |
      |to go for swim|fly high |to go for swim|
      |play games    |         |play games    |
      |fly high      |         |              |
