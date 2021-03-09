Feature: Test CRUD methods with API testing

  Scenario Outline: Verify collection of pets in the post
    Given I Set Get pet api endpoint
    When I perform Get operation for pets
    Then I receive valid HTTP response code <code>
    Examples:
      | code |
      | 200  |


  Scenario Outline: Create a new pet
    Given I want to create a new pet with name <name> and status <status>
    When I create the pet resource
    Then the pet will be created in the database with the name <name>
    Examples:
      | name  | status    |
      | Boris | available |


  Scenario Outline: Get the created pet
    Given I set the request HEADER
    When I send Get HTTP request
    Then I receive valid HTTP code <code> response
    And I receive the pet name <name>
    Examples:
      | code | name  |
      | 200  | Boris |

  Scenario Outline: Update the created pet
    Given I set a new name <name> and a new CategoryId <categoryId> for the created pet
    When I set a Put Http request
    And I receive a valid HTTP code <code>
    Examples:
      | name | categoryId | code |
      | Rexi | 20         | 200  |

  Scenario: Create another  pet
    Given I want to create another  pet
    When I create the new pet resource
    Then the pet will be created in the database

  Scenario: Update the previous created pet
    Given I set a new name and a new Id for category section
    When I set a Put Http request for the previous pet created
    And I receive the code request

  Scenario Outline: Get the previous pet created
    Given I set the request HEADER for revious pet created
    When I send Get request for specific pet
    Then I can see a valid HTTP code <code> Response
    And The pet name will be <name>
    Examples:
      | code | name  |
      | 200  | Leila |


  Scenario: Delete the first pet created
    Given I set DELETE pet api endpoint
    When I send DELETE HTTP request
    Then I receive valid HTTP Response

  Scenario Outline: Delete the second pet created
    Given I set the  DElETE pet api endpoint
    When I send DELETE  request
    Then I receive valid code <code>
    Examples:
      | code |
      | 200  |

  Scenario: Find pets by available status
    Given I send a new Http get request
    When I receive status code
    And I receive valid status





