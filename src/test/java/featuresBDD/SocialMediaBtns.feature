Feature: Test social-media buttons

  Scenario: Check if Facebook button works
    Given Open website
    When User clicks on Facebook button
    Then The user is able to navigate on Facebook page
    And Close the page

  Scenario: Check if Twitter button works
    Given Open website
    When User clicks on Twitter button
    Then The user is able to navigate on Twitter page
    And Close the page

  Scenario: Check if LinkedIn button works
    Given Open website
    When User clicks on LinkedIn button
    Then The user is able to navigate on LinkedIn page
    And Close the page

  Scenario: Check if Youtube button works
    Given Open website
    When User clicks on Youtube button
    Then The user is able to navigate on Youtube page
    And Close the page