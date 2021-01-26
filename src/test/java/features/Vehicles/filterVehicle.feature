Feature: I filter vehicles as a current user

  Scenario Outline: I filter vehicles as a current user
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    And I see the main dashboard as a current user
    And I click on Vehicles tab in sidebar on main page
    When I filter by status <status>, driver license <license> and type <type> in vehicles page
    And I click on filter button in vehicles page
    Then I should see a register with status <status>, driver license <license> and type <type>  in vehicles page

    Examples:
      | username       | password | status     | license | type  |
      | user@gmail.com | mypass   | DISPONIBLE | B      | Coche |
