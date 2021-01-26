Feature: I start new travel as a current user

  Scenario Outline: I add new travel as a current user
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    And I see the main dashboard as a current user
    And I click on Travels tab in sidebar on main page
    When I click on start travel button in travels page
    Then I should see the status <statusInit> of the travel changed
    When I click on finish travel button in travels page
    Then I should see the status <statusFinish> of the travel changed

    Examples:
      | username        | password | statusInit | statusFinish |
      | user@gmail.com | mypass   | EN CURSO   | FINALIZADO   |
