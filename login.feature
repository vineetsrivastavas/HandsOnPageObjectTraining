@tag
Feature: Validate the login feature
  @tag1
  Scenario: Successfull Login 
    Given I am in login page
    When I enter the username "tomsmith"
    And password "SuperSecretPassword!"
    Then I am able to login successfull

Scenario: Unsuccessfull Login 
    Given I am in login page
    When I enter the wrong username "user"
    And wrong password "SuperSecret"
    Then I am not able to login into the system