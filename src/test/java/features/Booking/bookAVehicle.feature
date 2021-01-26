Feature: I book a vehicle as a current user

  Scenario Outline: I book a vehicle as a current user
    Given I open Urbanio webpage in a new webBrowser
    And I login with the credentials username <username> and password <password> in the login page
    And I see the main dashboard as a current user
    And I click on Booking tab in sidebar on main page as a current user
    When I fill filter with vehicle <vehicle> and destination <destination> on booking page
    When I click on add booking button on booking page
    Then I should see the vehicle <vehicle> with status <status> on booking page
    And I click on unblock botton to free the vehicle

    Examples:
      | username       | password | vehicle | destination      | status    |
      | user@gmail.com | mypass   | 4532CDR | Destination test | RESERVADA |