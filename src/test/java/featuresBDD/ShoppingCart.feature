
Feature: Test Shopping Cart


  Scenario: Check if the user can add a product to the basket
    Given User accesses the Altex site
    When User searches for a product and clicks on Cauta btn
    And Clicks on a product from the suggested list
    And Clicks on a product from the by clicking on Adauga in cos btn
    Then User clicks on Vezi cosul btn
    And Closes the browser

  Scenario: Check if the user can add and delete a product from the basket by pressing x
    Given User accesses the Altex site
    When User searches for a product and clicks on Cauta btn
    And Clicks on a product from the suggested list
    And Clicks on a product from the by clicking on Adauga in cos btn
    And Clicks on Inapoi btn
    Then User clicks on Cosul meu btn and then on X button
    And Closes the browser

  Scenario: Check if user can increase or decrease the quantity of a product after adding it in the basket
    Given User accesses the Altex site
    When User searches for a product and clicks on Cauta btn
    And Clicks on a product from the suggested list
    And Clicks on a product from the by clicking on Adauga in cos btn
    And User clicks on Vezi cosul btn
    Then User clicks on + sign 2 times and on - one time in order to increase and decrese the quantity of the products
    And Closes the browser