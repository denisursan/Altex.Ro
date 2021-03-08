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

  Scenario: Delete the created pet
    Given I set DElETE pet api endpoint
    When I send DELETE HTTP request
    Then I receive valid HTTP Response





