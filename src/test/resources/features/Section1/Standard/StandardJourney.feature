@Regression
Feature: Example Feature file using Cucumber

  @Section1 @StandardPrelodged
  Scenario: exports standard declaration journey
    Given I enter EORI GB123456789000 on Login Page and click submit
    Then I should land on Choice page
    And I select to create a declaration
    Then I should land on Standard-Or-Other page
    And I select the STANDARD declaration option
    And I click continue
    Then I should land on Arrived-or-Prelodged page
    And I select a prelodged declaration type
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Do-You-Have-Ducr page
    And I select Yes to confirm i have a ducr
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
    And I click continue on MiniCya
    Then I should land on Are-You-The-Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select No on exporter eori number page
    And I click continue
    Then I should land on Exporter-Address page
    And I provide Exporter Address Details
    And I click continue
    Then I should land on On-Behalf-Of-Another-Agent page
    And I select No to hold the contract
    And I click continue
    Then I should land on Representatives-Eori-Number page
    And I provide Representatives Eori as GB121012121212
    And I click continue
    Then I should land on Representation-Type-Agreed page
    And I select Direct as the type of representation
    And I click continue
    Then I should land on Carrier-Eori-Number page
    And I select No on carrier eori number page
    And I click continue
    Then I should land on Carrier-Address page
    And I provide Carrier Address Details
    And I click continue
    Then I should land on Consignee-Details page
    And I provide consignee details
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select Consolidator party and GB121212121212 as the other party involved
    And I click continue
    Then I should land on Authorisation-Choice page
    And I select Permanent as export procedure choice
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    And I click continue
    Then I should land on Add-Authorisation-Required page
    And I select first Authorisation code ACR and enter eori GB123456789008
    And I click continue
    Then I should land on Authorisations-Required page
    And I select No to add another authorisations
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2
    And I click continue



  @Section1 @StandardPrelodged
  Scenario Outline: Fill Section 1 for a Simplified Prelogged and Arrived Declaration
    Given I enter EORI GB123456789006 on Login Page and click submit
    Then I should land on Choice page
    And I select to create a declaration
    Then I should land on Standard-Or-Other page
    And I select the STANDARD declaration option
    And I click continue
    Then I should land on Arrived-or-Prelodged page
    And I select a <DecType> declaration type
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Do-You-Have-Ducr page
    And I select Yes to confirm i have a ducr
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