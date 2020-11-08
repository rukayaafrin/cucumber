Feature: the Todo can be retrieved
  Scenario: client makes call to GET /todos
   	Given todo application is up
    When the client calls /todos
    Then the client receives status code of 200