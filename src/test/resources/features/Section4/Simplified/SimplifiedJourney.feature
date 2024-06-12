@Regression2
Feature: Section4 Simplified Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. checking prelodged and arrived type for section 4. Only we see previous documents page for section 4 on Simplified Declaration
     # 2. Validating Previous document page dynamic title changes

  @Section4 @Simplified
  Scenario Outline: Complete Transactions section on Simplified Prelodged declaration journey and validate dynamic title changes on previous documents page
    Given I fill section1 for SIMPLIFIED,<DecType> declaration
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

    # validate dynamic title change on previous documents page
    # check title on previous documents page when authorisation choice is Permanent with excise
    And I navigate to Authorisation Choice page
    And I select Permanent with excise as export procedure choice
    And I click continue
    And I navigate to Previous Documents page
    Then I should land on Previous-Document page

    # check title on previous documents page when authorisation choice is Temporary
    And I navigate to Authorisation Choice page
    And I select Temporary as export procedure choice
    And I click continue
    And I navigate to Previous Documents page
    Then I should land on Previous-Document page

    Examples:
      | DecType   |
      | prelodged |
      | arrived   |