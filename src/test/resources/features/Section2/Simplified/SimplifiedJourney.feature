@Regression
Feature: Section2 Simplified Journey Scenarios

  Background:
    Given I clear data in cache

    @Section2 @SimDec
    Scenario Outline: Exports Simplified Declaration When the user is not an exporter,
    not having EORI, not holding the contract to submit the declaration on behalf
    and not having the carrier EORI number with this selection the
    Given I fill section1 for SIMPLIFIED,<Type> declaration
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
    And I select first party Consolidator and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I click on remove link to delete party 0
    Then I should land on Other-Parties-Involved-Remove page
    And I select Yes to remove other party
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select first party Consolidator and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I click on remove link to delete party 0
    Then I should land on Other-Parties-Involved-Remove page
    And I select Yes to remove other party
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select first party Manufacturer and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I click on remove link to delete party 0
    Then I should land on Other-Parties-Involved-Remove page
    And I select Yes to remove other party
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select first party Freight forwarder and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I click on remove link to delete party 0
    Then I should land on Other-Parties-Involved-Remove page
    And I select Yes to remove other party
    And I click continue
    Then I should land on Other-Parties-Involved page
    And I select first party Warehouse keeper and eori GB121212121212 as the other party involved
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select No on other party involved list page
    And I click continue
    Then I should land on Authorisation-Choice page
    And I select Permanent as export procedure choice
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
      |   Type   |
      | preloged |
      |  arrived |

      Scenario: To check No other parties are involved option
        Given I fill section1 for SIMPLIFIED,preloged declaration
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
        And I select No other parties are involved
        And I click continue
        Then I should land on Authorisation-Choice page
        And I select Permanent as export procedure choice
        And I click continue
        Then I should land on Authorisation-Required page
        And I select first Authorisation code ACR and enter eori as GB123456789008
        And I click continue
        Then I should land on Authorisations-Required-List page
        And I select No to add another authorisation
        And I click continue
        Then I should land on MiniCYA-Section-2 page
        And I check the MiniCYA page for Section-2
