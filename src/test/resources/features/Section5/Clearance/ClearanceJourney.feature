@Regression
Feature: Clearance Journey Section 5

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. Clearance Prelodged Journey when IsEXS is No in section 2
     # 2. Changing IsEXS to Yes and validate dangerous goods page

  @Section5 @ClrDec
  Scenario: Complete Items section on Clearance PreLodged declaration journey
    Given I fill section1 for CLEARANCE,prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1100 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F44 as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 42034000 and description as Clothes
    And I click continue
    # missing dangerous code page when isEXS is No
    Then I should land on Package-Information page
    And I enter Cylinder as package type, 5 as number of packages and 67 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 5090 and net weight as 7010
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select Yes to add additional information
    And I click continue
    Then I should land on Additional-Information page
    And I enter 00409 as code and TESTER as required information as first additional information
    And I click continue
    Then I should land on Additional-Information-List page
    And I select No on additional information list page
    And I click continue
    Then I should land on Additional-Document page
    And I enter C676 as code and GBAEOC70057 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

    # changing isEXs Yes and validating dangerous codes page