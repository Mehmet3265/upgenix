Feature: Upgenix project login

 # User Story:As a user, I should be able to log in so that I can land on homepage.

  Background: Assuming user in the login page
    Given user is on the login page


  Scenario Outline:AC-1 Users can log in with valid credentials
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user enter login button
    Then user should see the homepage

    @tc1
    Examples: login with valid credentials
      | username                | password     |
      | salesmanager15@info.com | salesmanager |
      | posmanager15@info.com   | posmanager   |



Scenario Outline: Wrong login/password" message should be displayed for invalid username or password

     When user enters one invalid credential  "<username>"
     When user enters pasword "<password>"
     Then user should see Wrong login/password massage
  @tc2
  Examples: login with one valid one invalid credential
    | username                | password     |
    | invalid                 | salesmanager |
    | salesmanager15@info.com | invalid      |
    | invalid                 | posmanager   |
    | posmanager15@info.com   | invalid      |


  Scenario Outline:  "Please fill out this field" message should be displayed if the password or username is empty
    When username is empty
    When user enteRs valid pasword "<Password>"
    When clicks loginButton
    Then user should see Please fill out this field message

  Examples: login with one empty credential
    | Password     |
    | salesmanager |
    | posmanager   |


  Scenario Outline:  "Please fill out this field" message should be displayed if the password or username is empty

    When user enters VALID username "<Username>"
    When pasword is empty
    When clicks loginButton
    Then user should see Please fill out this field message for password


    Examples: login with one empty credential
      | Username                |
      | salesmanager15@info.com |
      | posmanager15@info.com   |



    Scenario Outline: User should see the password in bullet signs by default while typing (like ****)
      When user enters password "<password>"
      Then user should see input box signs as dots
      @TC-4
      Examples: Enter only password
        | password     |
        | salesmanager |
        | posmanager   |

      @tc5
      Scenario:  Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
        When user enters valid username "salesmanager15@info.com"
        And user enters valid password "salesmanager"
        And user enter login button from the keyboard
        Then user should see the homepage


