Feature: Test LogIn feature

  @SimpleTest
  Scenario: LogIn with valid credentials
    Given User accesses Altex website
    When I enter valid username and valid password
    Then The user is able to LogIn
    And Closes browser

  Scenario: LogIn with invalid(password) credentials
    Given User accesses Altex website
    When I enter valid username and invalid password
    Then The user is not able to LogIn
    And Closes browser

  Scenario: LogIn with invalid(email) credentials
    Given User accesses Altex website
    When I enter invalid username and valid password
    Then The user is not able to LogIn
    And Closes browser

  Scenario: Test logOut feature
    Given User accesses Altex website
    When I enter valid username and valid password
    Then The user is able to LogIn
    And The user is able to Log Out
    And Closes browser

  Scenario: Test LogIn feature from Am deja cont section
    Given User accesses Altex website
    When User clicks Contul meu btn
    And User clicks on Inregistrare btn
    Then User enters valid username and valid password
    And User is able to Log In
    And Closes browser