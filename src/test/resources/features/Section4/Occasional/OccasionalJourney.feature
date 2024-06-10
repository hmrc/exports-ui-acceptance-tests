@Regression2
Feature: Section4 Occasional Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. checking prelodged and arrived type for section 4. Only we see previous documents page for section 4 on Simplified Declaration

  @Section4 @Occasional
  Scenario Outline: Complete Transactions section on Occasional Prelodged and Arrived declaration journey
    Given I fill section1 for OCCASIONAL,<DecType> declaration
    And I fill section2
    And I fill section3
    Then I should land on Previous-Document page
    And I select as first Document Commercial Invoice as code and 9GB123456782317-BH1433A61 as reference
    And I click continue
    Then I should land on Previous-Documents-list page
    And I select No on previous documents list page
    And I click continue
    Then I should land on MiniCYA-Section-4 page
    And I check the MiniCYA page for Section-4
    And I click continue on MiniCya

    Examples:
      | DecType   |
      | prelodged |
      | arrived   |