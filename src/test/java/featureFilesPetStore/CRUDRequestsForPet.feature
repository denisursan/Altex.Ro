Feature: Test CRUD methods with API testing

  Scenario: Verify collection of pets in the post
    Given I Set Get pet api endpoint
    When I perform Get operation for pets
    Then I receive valid HTTP response code


  Scenario: Create a new pet
    Given I want to create a new pet with name and status
    When I create the pet resource
    Then the pet will be created in the database with the name


  Scenario: Get the created pet
    Given I set the request HEADER
    When I send Get HTTP request
    Then I receive valid HTTP code response
    And I receive the pet name

  Scenario: Update the created pet
    Given I set a new name and a new CategoryId for the created pet
    When I set a Put Http request
    And I receive valid HTTP code

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
    Given I set DElETE pet api endpoint
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





