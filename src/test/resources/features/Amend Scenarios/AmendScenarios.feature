Feature: Amend Scenarios

  Scenario: Full Standard Journey and view declaration in submission dashboard
    Given I fill section1 for STANDARD, prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I fill section6
    Then I should land on Saved-Summary page
    And I check the sections' headings and click confirm and continue
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I validate declaration details on Submitted tab and check Status is Arrived and accepted
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I validate that change links are not present for Section 1
    And I validate that change link is not present for location of goods
    And I should see the change links are there for other sections

##    Section-2 amending Exporter details
#    And I click change link for Exporter’s details page
#    Then I should land on Exporter-Eori-Number page
#    And I select No on exporter eori number page
#    And I click continue
#    Then I should land on Exporter-Address page
#    And I provide Exporter Address Details
#    And I click save and return to summary
#    Then I should land on Saved-Summary page

#    Section-2 amending Are you the exporter details to No
    Then I clear Section2 keys from cache
    And I click change link for Are you the exporter page
#    Then I should land on Are-You-The-Exporter page
    And I select Yes to I am the Exporter
    And I click continue
#    Then I should land on Third-Party-Goods-Transportation page
    And I select Yes on third party goods transportation page
    And I click continue
    Then I should land on Carrier-Eori-Number page
    And I select Yes on carrier eori number page and entered eori as GB121212121212
    And I click continue
    Then I should land on Consignee-Details page
    And I provide amended consignee details
    And I click continue
    Then I should land on Other-Parties-Involved-List page
    And I select No on other party involved list page
    And I click continue
    Then I should land on Authorisation-Choice page
    And I select Permanent with excise as export procedure choice
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click remove link to remove already added authorisation
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code ACR and enter eori as GB123456789008
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I should land on MiniCYA-Section-2 page
    And I navigate to summary page



    And I check the sections' headings and click confirm and continue
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
#    And I should land on Confirmation page
    And I click on Declaration status link on Confirmation page
#    Then I should land on Declaration-Information page
    And I click view details link on timeline page to view the amended details
    Then I validate amended details
    And I click back
    And I click Amend declaration link
    Then I should land on Saved-Summary page

  #    Adding an item on Amend Declaration
    And I click on Add Item link
    Then I should land on Procedure-codes page
    And I fill section5
    Then I navigate to summary page
    And I check the sections' headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page

  #    Removing an item on Amended Declatation
    And I click on Declaration status link on Confirmation page
    And I click Amend declaration link
    Then I should land on Saved-Summary page
#    And I click remove link to remove item 2
#    And I select (.*) to remove (.*) item











