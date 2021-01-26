Feature: I add new bill as an admin user

  Scenario Outline: I add new bill as an admin user
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    And I see the main dashboard as a current user
    And I click on Bills tab in sidebar on main page
    When I fill fields billNumber <billNumber>, name <name>, surnames <surnames>, vehicle <vehicle>, duration <duration> and status <status> in bills page
    And I click on save button in bills page
    Then I should see a register with billNumber <billNumber> in bills page

    Examples:
      | username        | password | billNumber | name     | surnames     | vehicle | duration | status |
      | admin@gmail.com | mypass   | US10344    | nameTest | surnamesTest | Coche   | 00:10:00 | Pagado |



