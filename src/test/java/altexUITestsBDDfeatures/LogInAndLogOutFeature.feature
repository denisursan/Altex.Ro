Feature: Test LogIn feature

  @SimpleTest
  Scenario Outline: LogIn with valid credentials
    Given User accesses Altex website
    When I enter valid email <email> and valid password <password>
    Then The user is able to LogIn
    And Closes browser
    Examples:
      | email             | password  |
      | rovidyu@yahoo.com | RRO_12345 |

  Scenario Outline: LogIn with invalid(password) credentials
    Given User accesses Altex website
    When I enter valid email <email> and invalid password <password>
    Then The user is not able to LogIn
    And Closes browser
    Examples:
      | email             | password |
      | rovidyu@yahoo.com | RRO_6523 |


  Scenario Outline: LogIn with invalid(email) credentials
    Given User accesses Altex website
    When I enter invalid email <email> and valid password <password>
    Then The user is not able to LogIn
    And Closes browser
    Examples:
      | email             | password |
      | rovidyu@gmail.com | RRO_6523 |

  Scenario Outline: Test logOut feature
    Given User accesses Altex website
    When I enter valid email <email> and valid password <password>
    Then The user is able to LogIn
    And The user is able to Log Out
    And Closes browser
    Examples:
      | email             | password  |
      | rovidyu@yahoo.com | RRO_12345 |


  Scenario: Test LogIn feature from Am deja cont section
    Given User accesses Altex website
    When User clicks Contul meu btn
    And User clicks on Inregistrare btn
    Then User enters valid username and valid password
    And User is able to Log In
    And Closes browser


  Scenario: Test if user is able to log in by pressing back button after logOut
    Given User accesses Altex website
    When I enter valid email <email> and valid password <password>
    Then The user is able to LogIn
    And The user is able to Log Out
    And User clicks on back button
    And The user is not able to LogIn back
    And Closes browser

