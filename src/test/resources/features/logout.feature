
Feature: Upgenix project logout

  Background:
    Given user is on the login page

    @1
  Scenario Outline:AC1- User can log out and ends up in login page.
      When user enters valid username "<username>"
      And user enters valid password "<password>"
      And user enter login button
      And user selects the log out option from topbar dropdown
      Then user should see the login page

      Examples: login with valid credentials
        | username                | password     |
        | salesmanager15@info.com | salesmanager |
        | posmanager15@info.com   | posmanager   |

     @2
  Scenario Outline: AC2- The user can not go to the home page again by clicking the step back button after successfully logged out.
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user enter login button
    And user selects the log out option from topbar dropdown
    And user clicks the step back button
    Then user should see Odoo Session Expired is dissplayed


    Examples: login with valid credentials
      | username                | password     |
      | salesmanager15@info.com | salesmanager |
      | posmanager15@info.com   | posmanager   |


  Scenario Outline: AC3- The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)

         When user enters valid username "<username>"
         And user enters valid password "<password>"
         And user enter login button
         And user closes all the tabs
         Then user should be logged out

         @3
         Examples: login with valid credentials
           | username                | password     |
           | salesmanager15@info.com | salesmanager |
           | posmanager15@info.com   | posmanager   |



