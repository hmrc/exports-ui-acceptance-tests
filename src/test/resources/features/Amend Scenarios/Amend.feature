@Regression1 @Smoke
Feature: Amend Scenarios

  Background:
    Given I clear data in cache

  Scenario: Full Standard Amend Journey and view declaration in submission dashboard
    Given I fill section1 for STANDARD, prelodged declaration
#    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I fill section6
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
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

    # Section-2 amending Are you the exporter details to No
    Then I clear Are you the exporter?,Carrier or haulier’s EORI number,Authorisation type  keys from cache
    And I click change link for Are you the exporter page
    Then I should land on Are-You-The-Exporter page
    And I select Yes to I am the Exporter
    And I click continue
    Then I should land on Third-Party-Goods-Transportation page
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
    And I check the section headings and click confirm and continue
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Declaration cleared
    And I navigate to declaration information page after clicking on mrn link
    And I click view details link on timeline page to view the amended details
    Then I validate amended details
    And I click back
    And I click Amend declaration link
    Then I should land on Saved-Summary page

    #Removing an item on Amended Declaration is not allowed, as the item is associated with the submitted declaration
    #When the user tried to remove the item then the respective warning message is displayed
    And I click remove link to remove item 1
    Then I should land on Remove-Declaration-Item page
    And I should see the warning that the item cannot be removed
    And I click cancel button to naviagate back to Amend Summary page
    Then I should land on Saved-Summary page

    #Adding an item on Amend Declaration
    And I click on Add Item link
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 28034001 and description as St Andrews Whisky
    And I click continue
    Then I should land on Dangerous-Goods-Code page
    And I select No to enter dangerous goods
    And I click continue
    Then I should land on Cus-Code page
    And I select No to enter CUS code
    And I click continue
    Then I should land on VAT-Rating page
    Then I select VAT exempt option as goods being VAT zero-rated
    And I click continue
    Then I should land on National-Additional-Code page
    And I select No to enter national additional code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 8000 as statistical value
    And I click continue
    Then I should land on Package-Information page
    And I enter Barrel as package type, with 122 packages and 1305 as shipping mark for first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 500 and net weight as 900
    And I click continue
    Then I should land on Supplementary-Units page
    And I select No to enter supplementary units
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select No to add additional information
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select No to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter C501 as code and GBAEOC71757 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No to add additional Documents
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    # And I check the MiniCYA page for Section-5 (At the moment we can able to validate one item, need to extend this to check two or more)

    Then I navigate to summary page
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Declaration cleared
    And I navigate to declaration information page after clicking on mrn link
    And I click view details link on timeline page to view the amended details
    Then I validate amended details

    # Exit and come back later and resuming saved declaration functionality for Amend Declaration
    And I click back
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I click change link for Office of exit page
    Then I should land on Office-Of-Exit page
    And I select Barrow in Furness with code GB003010 as the office of exit
    Then I click continue
    Then I should land on MiniCYA-Section-3 page
    And I click on Exit and comeback later link
    Then I should land on saved draft declaration page
    And I navigate to saved declarations
    Then I should land on Saved-Declarations page
    And I validate details on saved declarations page and check status is Amendment
    And I click on DUCR link for amended declaration
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Declaration cleared
    And I navigate to declaration information page after clicking on mrn link
    And I click view details link on timeline page to view the amended details
    Then I validate amended details

    # To verify Rejected Amendment on Timeline page
    And I click back
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I click change link for Border transport page
    Then I should land on Border-Transport page
    And I select Ship IMO number as the border transport
    And I click save and return to summary
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is On hold
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Amendment rejected status on timeline

    # To verify amendment cancellation on rejected amendments on Timeline page
    And I click back
    And I navigate to declaration information page after clicking on mrn link
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I click change link for Border transport page
    Then I should land on Border-Transport page
    And I select Ship IMO number as the border transport
    And I click save and return to summary
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is On hold
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Amendment rejected status on timeline

    And I click on cancel link on rejected amendment
    Then I should land on Cancel-Declaration page
    And I select No longer required as the reason and enter description for cancellation
    And I click continue
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is On hold
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Amendment cancelled status on timeline

    # To verify Failed Amendment in Timeline page
    And I click back
    And I navigate to declaration information page after clicking on mrn link
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I click change link for Border transport page
    Then I should land on Border-Transport page
    And I select Ship name as the border transport
    And I click save and return to summary
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is On hold
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Amendment failed status on timeline

    # To verify Pending Amend declaration with Amendment requested notification on Timeline page
    And I click back
    And I navigate to declaration information page after clicking on mrn link
    And I click Amend declaration link
    Then I should land on Saved-Summary page
    And I click change link for Border transport page
    Then I should land on Border-Transport page
    And I select Train as the border transport
    And I click save and return to summary
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is On hold
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Amendment requested status on timeline