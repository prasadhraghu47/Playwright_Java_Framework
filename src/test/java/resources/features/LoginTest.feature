Feature: Login Feature

  @test
  Scenario: Successful login with valid credentials
    Given user is on login page "https://www.saucedemo.com/"
    When user logs in with valid credentials
      | Username      | Password     |
      | standard_user | secret_sauce |
    Then user should see the dashboard