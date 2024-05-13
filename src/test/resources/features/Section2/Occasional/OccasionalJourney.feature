@Regression
Feature: Section2 Occasional Journey Scenarios

  Background:
    Given I clear data in cache

     ## Below scenario -
  # 1. Occasional Prelodged and Arrived Declarations
  # 2. Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI
  #    third party goods transportation page as Yes and Freight forwarder for Other parties involved
  # 3. Both journeys to cover maximum pages

  @Section2 @OcaDec
  Scenario Outline: Exports Occasional declaration (Prelodged and Arrived)
    Given I fill section1 for OCCASIONAL,<Type> declaration
    Then I should land on Are-You-The-Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select Yes on exporter eori number page and enter eori number as GB121012121214
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
    Then I should land on Third-Party-Goods-Transportation page
    And I select Yes on third party goods transportation page
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
    And I select first party Additional freight forwarder and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select No on other party involved list page
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2

    Examples:
    |Type          |
    | arrived      |
    | prelodged    |