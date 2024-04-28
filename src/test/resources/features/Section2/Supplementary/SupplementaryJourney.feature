@Regression
Feature: Section2 Supplementary Journey

  Background:
    Given I clear data in cache

  ## Below scenario -
  # 1. Supplementary SDP and EIDR Declarations
  # 2. Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI
  # 3. Third party goods transportation page is not visible in Supplementary (Simplified and EDR) journeys
  # 4. To check the remove functionality for Authorisation choice and Other parties involved

  @Section2 @SupDec
  Scenario Outline: Exports Supplementary SDP and eidr Scenarios

    Given I fill section1 for SUPPLEMENTARY,<DecType> declaration
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
    Then I should land on Consignee-Details page
    And I provide consignee details
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select first party Consolidator and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select Yes on other party involved list page
    Then I should land on Other-Parties-Involved-List page
    And I click on remove link to delete party 0
    Then I should land on Other-Parties-Involved-Remove page
    And I select Yes to remove other party
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select second party Manufacturer and eori GB121212131313 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select No on other party involved list page
    And I click continue
    Then I should land on Authorisation-Choice page
    And I select Permanent as export procedure choice
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACP and enter eori as GB123456789009
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2
    And I click continue on MiniCya

    #  User is on the Exporter Details page
    #  selects "Exporter-eori-number = yes"
    #  the following pages are skipped
    #           Exporter-Eori-Number,
    #           Exporter-Address,
    #           On-Behalf-Of-Another-Agent,
    #           Representatives-Eori-Number,
    #           Representation-Type-Agreed
    Then I navigate to Are You The Exporter page
    And I clear Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation keys from cache
    And I select Yes to I am the Exporter
    And I click continue
    Then I should land on Consignee-Details page
    Then I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    Examples:
      | DecType        |
      | simplified     |
      | eidr           |