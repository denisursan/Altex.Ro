Feature: Test LogIn feature


  Scenario: LogIn with valid credentials
    Given User accesses https://altex.ro/
    When I enter valid username and valid password
    Then The user is able to LogIn
    And Closes browser


