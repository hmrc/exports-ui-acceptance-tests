@Regression
Feature: Section2 Clearance Prelodged

  Background:
    Given I clear data in cache

  @Section2 @ClrDec
  Scenario: Exports Clearance Prelodged Scenario When the user is not having
  entry in declarant records is not an exporter,not having EORI, not holding
  the contract to submit the declaration on behalf and not having the carrier EORI number
    Given I fill section1 for CLEARANCE,prelodged declaration
    Then I should land on Entry-Into-Declarant-Records page
    And I select No to is this an entry into declarant records
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Are-You-The-Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select No on exporter eori number page
    And I click continue
    Then I should land on Exporter-Address page
    And I provide Exporter Address Details
    And I click continue
    Then I should land on Is-This-Exs page
    And I select Yes to is this exs
    And I click continue
    Then I should land on Consingor-EORI-Number page
    And I select No to consignor eori number
    And I click continue
    Then I should land on Consingor-Address page
    And I provide consignor details
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
    And I select No on third party goods transportation page
    And I click continue
    Then I should land on Consignee-Details page
    And I provide consignee details
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    And I click continue
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2
    And I click continue on MiniCya

    #  User is on the Entry into declarant records page
    #  selects "isEIDR = yes"
    #  navigates to Person Presenting Goods page
    #  the following pages are skipped
    #           Declarant-Details,
    #           Are-You-The-Exporter,
    And I navigate to Entry Into Declarant Records page
    Then I select Yes to is this an entry into declarant records
    And I click continue
    Then I should land on Person-Presenting-Goods page
    And I enter entered eori as GB121212121212
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    #  User is on the Entry into declarant records page
    #  selects "isEIDR = No" and "areYouTheExporter = No"
    #  user navigates to the following pages
    #                On-Behalf-Of-Another-Agent page
    #                representative-eori page
    #                representative-type-agreed page
    And I clear Exporter’s details, Consignor’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details keys from cache
    Then I navigate to Is This EXS page
    And I select No to is this exs
    And I click continue
    Then I navigate to On-Behalf-Of-Another-Agent page
    And I select No to hold the contract
    And I click continue
    Then I should land on Representatives-Eori-Number page
    And I provide Representatives Eori as GB121012121212
    And I click continue
    Then I should land on Representation-Type-Agreed page
    And I select Direct as the type of representation
    And I click continue
    Then I should land on Consignee-Details page
    And I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

    #  User is on the Entry into declarant records page
    #  selects "isEIDR = Yes"
    #  navigates to Authorisation choice page
    #  the following pages are skipped
    #            Are-you-the-exporter
    #            Declarant details
    #            are-you-completing-this-declaration-on-behalf-of-another-agent
    #            representative-eori-number
    #            representation-type-agreed
    And I clear Is this an EIDR?, Carrier or haulier’s EORI number, Exporter’s details, Consignor’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details keys from cache
    And I navigate to Entry Into Declarant Records page
    And I select Yes to is this an entry into declarant records
    And I click continue
    Then I should land on Person-Presenting-Goods page
    And I enter entered eori as GB123456789123
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select Yes on carrier eori number page and entered eori as GB171357178688000
    And I click continue
    Then I should land on Is-This-Exs page
    And I select Yes to is this exs
    And I click continue
    Then I should land on Consingor-EORI-Number page
    And I select Yes on consignor eori number page and enter eori number as GB123456789124
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
    And I select No on third party goods transportation page
    And I click continue
    Then I should land on Consignee-Details page
    And I provide consignee details
    And I click continue
    Then I should land on Authorisation-Choice page
    And I navigate to Summary Section2 page
    And I check the MiniCYA page for Section-2

  @Section2 @Smoke @ClrDec
  Scenario: Exports Clearance Arrived Scenario When the user is not having
  entry in declarant records is not an exporter,not having EORI, not holding
  the contract to submit the declaration on behalf and not having the carrier EORI number
    Given I fill section1 for CLEARANCE,arrived declaration
    Then I should land on Entry-Into-Declarant-Records page
    And I select No to is this an entry into declarant records
    And I click continue
    Then I should land on Declarant-Details page
    And I select Yes to confirm my eori
    And I click continue
    Then I should land on Are-You-The-Exporter page
    And I select No to I am the Exporter
    And I click continue
    Then I should land on Exporter-Eori-Number page
    And I select No on exporter eori number page
    And I click continue
    Then I should land on Exporter-Address page
    And I provide Exporter Address Details
    And I click continue
    Then I should land on Is-This-Exs page
    And I select Yes to is this exs
    And I click continue
    Then I should land on Consingor-EORI-Number page
    And I select No to consignor eori number
    And I click continue
    Then I should land on Consingor-Address page
    And I provide consignor details
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
    And I select No on third party goods transportation page
    And I click continue
    Then I should land on Consignee-Details page
    And I provide consignee details
    And I click continue
    Then I should land on Is-Authorisation-Required page
    And I select Yes to declare authorisations
    And I click continue
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I check the MiniCYA page for Section-2
    And I click continue on MiniCya

