Feature: MathJS
  As a tester
  I want to test the MathJS webservice
  To realize the serenity-resassured-bootstrap

  Scenario Outline: GET Request
    When the user wants to evaluate the <expression> in MathJS
    Then he should see the <expected_result> in the browser

    Examples:
    | expression | expected_result |
    | 2+3 | 5 |
    | 2*(7-3) | 8 |


  Scenario: POST Request
    When the user wants to evaluate sin(45 deg)^2 of alternative way in MathJS
    Then he should see the correct structure in the answer

