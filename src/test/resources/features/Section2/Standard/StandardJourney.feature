@Regression
Feature: Section2 Standard Prelodged

  Background:
    Given I clear data in cache
  #The initial section 2 Journey starts with below combination
  #isExporter=NO, isExporterEORI=NO, holdTheContract=NO, carrierEoriNumber=No

  @Section2 @StandardPrelodgedJourney
  Scenario: Exports Standard Prelodged Scenario When the user is not an exporter,
            not having EORI, not holding the contract to submit the declaration on behalf
            and not having the carrier EORI number
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

    #  Given the user is on the Goods Transportation Details page
    #  When the user selects "Third party goods transportation = Yes"
    #  Then the Consignee Details page should be skipped
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

    #  Given the user is on the Goods Transportation Details page
    #  When the user selects "Third party goods transportation = No"
    #  Then the Carrier EORI Number field should be skipped
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

    #  Given the user is on the Exporter Details page
    #  When the user selects "Exporter-eori-number = yes"
    #  Then the Exporter Address page should be skipped
    Then I navigate to Are You The Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select Yes on exporter eori number page and enter eori number as GB123456789008
    And I click continue
    Then I should land on On-Behalf-Of-Another-Agent page

    #  Given the user is on the Are-you-completing-this-declaration-on-behalf-of-another-agent page
    #  When the user selects yes"
    #  Then the Representative EORI Number page should be skipped
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

     #  Given the user is on the authorization details page
     #  When the user changes the holder of authorization from "Permanent" to "Permanent with excise"
     #  Then the authorization holder is updated to "Permanent with excise"
    And I navigate to Summary Section2 page
    Then I click change link for Authorisation Type page
    And I select Permanent with excise as export procedure choice
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    Then I should land on Authorisations-Remove page
    And I click continue
    And I select first Authorisation code ACP and enter eori as Declarant EORI
    And I click continue
    Then I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    #  Given the user is on the authorisation choice page
    #  When the user changes the authorisation choice from "Permanent with excise" to "Temporary"
    #  Then the authorisation choice is updated to "Temporary"
    Then I click change link for Authorisation Type page
    And I select Temporary as export procedure choice
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    Then I should land on Authorisations-Remove page
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    And I click continue
    And I select first Authorisation code ACP and enter eori as Declarant EORI
    And I click continue
    Then I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2


  @Smoke @Section2 @StandardArrivedJourney
  Scenario: Exports Standard Arrived Scenario When the user is not an exporter,
  not having EORI, not holding the contract to submit the declaration on behalf
  and not having the carrier EORI number
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







