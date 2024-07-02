@Regression1 @Smoke
Feature: Supplementary Journey

  Background:
    Given I clear data in cache

  @Section1 @Supplementary
  Scenario Outline: Fill Section 1 for a Supplementary Non Eidr and Eidr
    Given I enter EORI GB123456789017 on Login Page and click submit
    Then I should land on Choice page
    And I select to create a declaration
    Then I should land on Standard-Or-Other page
    And I select the OTHER declaration option
    And I click continue
    And I should land on Declaration-Choice page
    And I select the SUPPLEMENTARY declaration
    And I click continue
    Then I should land on Arrived-or-Prelodged page
    And I select a <DecType> declaration type
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Consignment-References page
    And I enter 1GB121212121212-INVOICE123/4 as Ducr, <dateOrMrn> mrn or date and QSLRN8514100 as LRN
    And I click continue
    Then I should land on MiniCYA-Section-1 page
    And I check the MiniCYA page for Section-1
    Examples:
      | DecType    | dateOrMrn          |
      | eidr       | 20230401           |
      | simplified | 20GB46J8TMJ4RF1207 |
