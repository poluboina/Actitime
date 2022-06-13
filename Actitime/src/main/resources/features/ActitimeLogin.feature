Feature: Actitime Login

  Scenario Outline: Verify Actitime Valid Login
    Given user on Login Page
    When user enters username as <username>
    And user enters password as <password>
    And user clicks on Login button
    Then user should be on home page

    Examples: 
      | username | password |
      | admin    | manager  |
