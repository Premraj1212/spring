@e2e @add
Feature: Add tasks in the application
  In order to record all the task
  As a user
  I should be able to add all the tasks in the application

  Background:
    Given user has logged onto the application

  Scenario: User adds multiple tasks
    Given user todo list is empty
    When user adds following tasks:
      |to go for swim|
      |play games    |
      |fly high      |
    Then user should see all task listed in the application:
      |to go for swim|
      |play games    |
      |fly high      |