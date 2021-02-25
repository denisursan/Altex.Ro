
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

  Scenario: User is not able to acces the basket if no product is added to itet
    Given User accesses the Altex site
    When User clicks on Cosul meu btn
    Then User is prompted with a message saying that Nu exista produse and is not able to access the basket
    And Closes the browser

  Scenario: User is able to access the basket only if adding a product to it
    Given User accesses the Altex site
    When User navigates to Produse tab -> Electrocanice mari -> Uscatoare de rufe and adds a random product to the basket
    And User clicks on the Vezi cosul button
    And User clicks on Acasa button located in the top left corner
    And User clicks on Cosul meu button and a drop down opens
    Then User clicks on Vezi cosul button
    And Closes the browser

    Scenario: Check if all the products added to the basket are displayed
      Given User accesses the Altex site
      When User navigates to telefoane and adds three products in the basket
      And User clicks on Cosul meu btn and then on Vezi cosul meu btn
      Then User must see the added products in the basket
      And Closes the browser

  Scenario: Check if the products are displayed in the "Cosul meu" drop-down
    Given User accesses the Altex site
    When User navigates to telefoane and adds three products in the basket
    And User clicks on Cosul meu btn
    Then User must see the added products in the drop-down basket
    And Closes the browser