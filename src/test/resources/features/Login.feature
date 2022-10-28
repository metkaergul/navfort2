Feature: Login functionality

  User Story :
  User  should be able to login.
  Only authenticated users can access to application
  1-)DRIVER
  2-)SALES MANAGER
  3-)DRIVER

  Background: User is successfully land on the login page
    Given user is on the login page

  Scenario Outline: Login with valid credentials.
    When user enters valid  "<username>" and "<password>"
    Then  User should land on the "<Header>" page after login

    Examples:
      | username        | password    | Header          |
      | salesmanager101 | UserUser123 | Dashboard       |
      | salesmanager102 | UserUser123 | Dashboard       |
      | salesmanager103 | UserUser123 | Dashboard       |
      | storemanager51  | UserUser123 | Dashboard       |
      | storemanager52  | UserUser123 | Dashboard       |
      | storemanager53  | UserUser123 | Dashboard       |
      | user1           | UserUser123 | Quick Launchpad |