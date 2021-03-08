Feature: CRUD feature for order database

  Scenario: Create a new order
    Given I want to create a new order with in the database
    When I POST the created order
    Then the order will be created in the database with a valid HTTP

  Scenario: Get the created order
    Given I set the  order request
    When I send Get request for a specific order
    Then I receive valid HTTP code response for order request
    And I verify the order by Id

  Scenario: Delete the created order
    Given I want to delete the created order
    When I set a Delete Http request for the created order
    Then I receive delete validation for the order as an HTTP code

  Scenario Outline: Check if order was deleted
    Given I want to get the deleted order
    When I perform Get operation for specific order
    Then The response code  will be <code>
    Examples:
      | code |
      | 404  |

  Scenario: Check inventory status
    Given I want to get the inventory
    When I perform Get operation
    And I receive a valid response code
