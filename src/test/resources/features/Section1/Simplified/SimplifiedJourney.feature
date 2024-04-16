@Regression
Feature: Simplified Journey

  Background:
    Given I clear data in cache

  ## Below scenario - DoYouHaveADucr:[No], Confirm-Ducr:[No], Link-to-Mucr:[Yes]
  @Section1 @SimDec
  Scenario Outline: Fill Section 1 for a Simplified Prelodged and Arrived Declaration
    Given I enter EORI GB123456789006 on Login Page and click submit
    Then I should land on Choice page
    And I select to create a declaration
    Then I should land on Standard-Or-Other page
    And I select the OTHER declaration option
    And I click continue
    And I should land on Declaration-Choice page
    And I select the SIMPLIFIED declaration
    And I click continue
    Then I should land on Arrived-or-Prelodged page
    And I select a <DecType> declaration type
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Do-You-Have-Ducr page
    And I select No to confirm i have a ducr
    And I click continue
    Then I should land on Trader-Reference page
    And I click enter trader reference as INV956822/101SHIP1
    And I click continue
    Then I should land on Confirm-Ducr page
    And I select No to use the Ducr created by eori and reference
    And I click continue
    Then I should land on Ducr-Entry page
    And I enter Ducr 3GB986007773125-INVOICE123
    And I click continue
    Then I should land on Lrn page
    And I enter LRN MSLRN2872100
    And I click continue
    Then I should land on Link-To-Mucr page
    And I select Yes to link MUCR to DUCR
    And I click continue
    Then I should land on Enter-A-Mucr page
    And I enter Mucr as GB/AZ09-B12345
    And I click continue
    Then I should land on MiniCYA-Section-1 page
    And I check the MiniCYA page for Section-1

    Examples:
      | DecType   |
      | prelodged |
      | arrived   |