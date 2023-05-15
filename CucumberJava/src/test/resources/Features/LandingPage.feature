Feature: feature to test login page

  Scenario: Verify Logged successfully on required page
    Given user is logged into page
    When user clicks on English button
    And user clicks on classic plan
    Then verify user clicks on LITE plan
