Feature: To Verify API Automation with Rest Assured

  Scenario Outline: To verify Rest Service - GET Method
    Given I want to execute all colour lovers pattern
    When I submit the GET request
    Then I should get 200 Success Status Code
    Examples:
      |  |


  Scenario Outline: Assert on numViews greater than 4000
    Given I want to execute all colour lovers pattern
    When I submit the GET request
    Then I should get all numViews greater than 4000
    Examples:
      |  |