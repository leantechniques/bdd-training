Feature: Stack
  As a student
  I need to develop a stack
  so that I understand who to grow systems with tests

  @WIP
  Scenario: Empty stack is size of zero
    Given stack is empty
    Then size is 0

  @WIP
  Scenario: Size returns number on the stack
    When ‘A’ is Put on stack
    Then size is 1

  @WIP
  Scenario: Pop an empty stack throw an exception
    Given stack is empty
    When stack is popped
    Then exception is thrown

  @WIP
  Scenario: Put an item on the stack
    When ‘A’ is Put on stack
    Then top of stack is ‘A’

  @WIP
  Scenario: Pop an item off the stack
    Given ‘A’ is on top of stack
    When stack is popped
    Then ‘A’ is returned