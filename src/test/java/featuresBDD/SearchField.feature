Feature: Test Search Field

  Scenario: Search for products
    Given User accesses Altex site
    When User inserts Laptop in the Search Field
    Then User receives laptop results
    And Close browser