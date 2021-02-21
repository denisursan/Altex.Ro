Feature: Test LogIn and Log Out feature

@SimpleTest
  Scenario: LogIn with valid credentials
<<<<<<< HEAD:src/test/java/featuresBDD/LogInAndLogOutFeature.feature
    Given User accesses Altex Website
=======
    Given User accesses Altex website
>>>>>>> Branch-Denis:src/test/java/featuresBDD/LogIn.feature
    When I enter valid username and valid password
    Then The user is able to LogIn
    And Closes browser

  Scenario: LogIn with invalid(password) credentials
<<<<<<< HEAD:src/test/java/featuresBDD/LogInAndLogOutFeature.feature
    Given User accesses Altex Website
=======
    Given User accesses Altex website
>>>>>>> Branch-Denis:src/test/java/featuresBDD/LogIn.feature
    When I enter valid username and invalid password
    Then The user is not able to LogIn
    And Closes browser

  Scenario: LogIn with invalid(email) credentials
<<<<<<< HEAD:src/test/java/featuresBDD/LogInAndLogOutFeature.feature
    Given User accesses Altex Website
=======
    Given User accesses Altex website
>>>>>>> Branch-Denis:src/test/java/featuresBDD/LogIn.feature
    When I enter invalid username and valid password
    Then The user is not able to LogIn
    And Closes browser

<<<<<<< HEAD:src/test/java/featuresBDD/LogInAndLogOutFeature.feature
  Scenario: Test logOut feature
    Given User accesses Altex Website
    When I enter valid username and valid password
    Then The user is able to LogIn
    And The user is able to Log Out
    And Closes browser
=======
    Scenario: Test logOut feature
      Given User accesses Altex website
      When I enter valid username and valid password
      Then The user is able to LogIn
      And The user is able to Log Out
      And Closes browser
>>>>>>> Branch-Denis:src/test/java/featuresBDD/LogIn.feature
