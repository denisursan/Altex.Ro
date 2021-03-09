Feature: Test Search Field

  @SimpleTest
  Scenario Outline: Check if user is able to search for a product by "Cauta" button
    Given User accesses Altex site
    When User inserts product <product> in the Search Field and clicks on the search button
    Then User receives laptop results
    And Close browser
    Examples:
      | product |
      | laptop  |

  Scenario Outline: Check if user is able to search for a product by pressing ENTER key
    Given User accesses Altex site
    When User inserts product <product> in the Search Field and presses ENTER key
    Then User receives iphone results
    And Close browser
    Examples:
      | product |
      | iphone  |

  Scenario Outline:Check if the user can search for a product and select the suggested product
    Given User accesses Altex site
    When User inserts product <product> in the Search Field and select the suggested product
    Then User is able to navigate to the selected product's page
    And Close browser
    Examples:
      | product |
      | iphone  |

  Scenario:Check if the user can search for a product and select the suggested category product
    Given User accesses Altex site
    When User inserts product <product> in the Search Field and select the suggested category product
    Then User is able to navigate to the selected product's category page
    And Close browser
    Examples:
      | product |
      | anvelopa  |