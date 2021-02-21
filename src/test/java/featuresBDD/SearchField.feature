Feature: Test Search Field

<<<<<<< HEAD

  Scenario: Search for products
   Given User accesses the Altex Website
    When User inserts Laptop in the Search Field
    Then User receives laptop results
=======
  Scenario: Check if user is able to search for a product by "Cauta" button
    Given User accesses Altex site
    When User inserts Laptop in the Search Field and clicks on the search button
    Then User receives laptop results
    And Close browser

  Scenario: Check if user is able to search for a product by pressing ENTER key
    Given User accesses Altex site
    When User inserts Iphone in the Search Field and presses ENTER key
    Then User receives iphone results
    And Close browser

  Scenario:Check if the user can search for a product and select the suggested product
    Given User accesses Altex site
    When User inserts Iphone in the Search Field and select the suggested product
    Then User is able to navigate to the selected product's page
    And Close browser

  Scenario:Check if the user can search for a product and select the suggested category product
    Given User accesses Altex site
    When User inserts Anvelopa in the Search Field and select the suggested category product
    Then User is able to navigate to the selected product's category page
>>>>>>> Branch-Denis
    And Close browser