@Regression
Feature: Section2 Standard Prelodged

  Background:
    Given I clear data in cache

  ## Below scenario -
  # 1. Standard Prelodged Declaration
  # 2. Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI
  #    yes for third party goods transportation page and Permanent as Procedure Choice
  # 3. With the above combination the navigation through Is-Authorisation-Required page

  @Section2 @StdDec
  Scenario: Exports Standard Prelodged Scenario with Permanent as export procedure code choice, Consolidator and Manufacturer as other
            parties are involved
    Given I fill section1 for STANDARD,prelodged declaration
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
    And I select first party Consolidator and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select Yes on other party involved list page
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
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2
    And I click continue on MiniCya

    #  User is on the Goods Transportation Details page
    #  selects "Third party goods transportation = Yes"
    #  the Consignee Details page should be skipped
    Then I navigate to Are You The Exporter page
    And I select Yes to I am the Exporter
    And I clear Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation keys from cache
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
    And I select Yes on third party goods transportation page
    And I click continue
    Then I should land on Carrier-Eori-Number page
    Then I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    #  User is on the Goods Transportation Details page
    #  selects "Third party goods transportation = No"
    #  the Carrier EORI Number field should be skipped
    Then I navigate to Are You The Exporter page
    And I select Yes to I am the Exporter
    And I clear Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details keys from cache
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
    And I select No on third party goods transportation page
    And I click continue
    Then I should land on Consignee-Details page
    Then I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    #  User is on the Exporter Details page
    #  selects "Exporter-eori-number = yes"
    #  the Exporter Address page should be skipped
    Then I navigate to Are You The Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select Yes on exporter eori number page and enter eori number as GB123456789008
    And I click continue
    Then I should land on On-Behalf-Of-Another-Agent page

    #  User is on the Are-you-completing-this-declaration-on-behalf-of-another-agent page
    #  selects yes"
    #  the Representative EORI Number page should be skipped
    Then I navigate to Are You The Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select Yes on exporter eori number page and enter eori number as GB123456789008
    And I click continue
    Then I should land on On-Behalf-Of-Another-Agent page
    And I select Yes to hold the contract
    And I click continue
    Then I should land on Representation-Type-Agreed page


  ## Below scenario -
  # 1. Standard Arrived Declaration
  # 2. Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI
  #    yes for third party goods transportation page and Temporary as Procedure Choice
  # 3. With the above combination the page Is-Authorisation-Required is skipped

  @Smoke @Section2 @StdDec
  Scenario: Exports Standard Arrived Scenario with Temporary as export procedure code choice and No other
            parties are involved
    Given I fill section1 for STANDARD,arrived declaration
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
    And I select No for other parties are involved
    And I click continue
    Then I should land on Authorisation-Choice page
    And I select Temporary as export procedure choice
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2







