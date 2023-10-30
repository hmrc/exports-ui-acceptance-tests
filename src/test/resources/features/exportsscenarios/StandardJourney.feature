@wip
Feature: Standard Journey

  Scenario : To successfully submit standard prelodged journey
    Given I navigate to login stub page and provide enrolment key, eori as "GB757002374003" with exports redirect url to navigate to choice page
    And I select "CreateDeclaration" to start standard prelodged declaration

