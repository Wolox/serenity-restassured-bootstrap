Feature: MathJS
  As a tester
  I want to test the MathJS webservice
  To realize the serenity-resassured-bootstrap

  Scenario Outline: GET Request - <scenario>
    When I request evaluation of <expression>
    Then I should get <expected_result>
    And I should get status <code>

    Examples:
    | scenario | expression | expected_result | code |
    | successful | 2+3 | 5 | 200 |
    | successful | 2*(7-3) | 8 | 200 |
    | failed | 2+3*sqrt(4) | 1 | 400 |

  Scenario: POST Request
    When I request evaluation with POST request of sin(45 deg)^2
    Then I verify the correct schema

