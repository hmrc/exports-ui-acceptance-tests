@Regression
Feature: Clearance Journey Section 5

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. Clearance Prelodged Journey when IsEXS is No in section 2
     # 2. Changing IsEXS to Yes and validate dangerous goods page

  @Section5 @Clearance
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
    And I enter only description as Old St Andrews golf ball whisky on commodity details page
    And I click continue
    # Skipping dangerous code page when isEXS is No
    Then I should land on Package-Information page
    And I enter Cylinder as package type, with 5 packages and 67 as shipping mark for first package info
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
    And I enter C676 as code and GBAEOC70057 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

  # check Fiscal Reference pages when Procedure code is 1042
    And I navigate to Procedure codes page
    And I select 1042 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F75 as additional procedure code
    And I click continue


    # changing isThisEXS Yes and validating dangerous codes page
    And I navigate to Is This EXS page
    And I select Yes to is this exs
    And I click continue
    And I navigate to Commodity-Details page
    And I click continue
    And I should land on Dangerous-Goods-Code page
    And I select Yes to enter the code 1204 as dangerous goods
    And I click continue
    And I navigate to MiniCYA page for Section-5
    And I check the MiniCYA page for Section-5

     ## Below scenario -
     # 1. Clearance Arrived Journey when IsEXS is No in section 2
     # 2. Selecting procedure codes when EIDR in section 2 is No on a arrived declaration

  @Section5 @Clearance
  Scenario: Complete Items section on Clearance Arrived declaration journey
    Given I fill section1 for CLEARANCE,arrived declaration
    And I fill section2
    And I fill section3
    And I fill section4

    # check procedure code when IsEIDR is Yes
    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1100 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F44 as additional procedure code
    And I click continue

    # check procedure code when IsEIDR is No
    And I navigate to Entry Into Declarant Records page
    And I select No to is this an entry into declarant records
    And I click continue
    And I navigate to Procedure codes page
    And I select 0015 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 11A as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 42034000 and description as Clothes
    And I click continue
    # missing dangerous code page when isEXS is No
    Then I should land on Package-Information page
    And I enter Cylinder as package type, with 5 packages and 67 as shipping mark for first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 5090 and net weight as 7010
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select No to add additional information
    And I click continue
    Then I should land on Additional-Document page
    And I enter C676 as code and GBAEOC70057 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

