@Regression3
Feature: Validate Dashboard and Declaration Information

  Background:
    Given I clear data in cache

    # Below scenario -
    # 1. Check various confirmation page titles and validates information on Dashboard and Declaration information pages
    # 2. Validates View Print link
    # 3. Checks successful and unsuccessful Copy of a Declaration
    # 4. Checks successful and unsuccessful Cancellation of a Declaration

  Scenario: Full Standard Journey and view declaration in submission dashboard
    Given I fill section1 for STANDARD, prelodged declaration
    And I fill section2
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

    # Submit declaration with LRN starting with Q to check Query raised status and
    # checks warning message of a lrn used in 24 hours
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123406469274-101SHIP1 and lrn used within 24 hours
    And I click continue
    Then I am displayed with a lrn warning message
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with Q0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is Query raised
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Submit a Prelodged declaration with LRN starting with C to check
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with C0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Arrived and accepted
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Submit a declaration with LRN starting with X to check Goods have exited the UK status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with X0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Goods have exited the UK
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Submit a declaration with LRN starting with D to check Documents required status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with D0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Action needed tab
    And I validate declaration details on Action needed tab and check Status is Documents required
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

   # Submit a declaration with LRN starting with R to check Declaration submitted status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with R0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Declaration submitted
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page


   # Submit a declaration with LRN starting with U to check Goods being examined
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with U0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Goods being examined
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

   # Submit a arrived declaration with LRN starting with C to check Declaration cleared status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with C0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
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
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Submit a arrived declaration with LRN starting with I to check Awaiting Exit Results status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with I0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Awaiting exit results
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

     # Submit a arrived declaration with LRN starting with L to check Declaration expired on departure status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with L0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Cancelled & expired tab
    And I validate declaration details on Cancelled & expired tab and check Status is Declaration expired (no departure)
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

     # Submit a arrived declaration with LRN starting with K to check Declaration expired on arrived status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with K0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Cancelled & expired tab
    And I validate declaration details on Cancelled & expired tab and check Status is Declaration expired (no arrival)
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Submit a arrived declaration with LRN starting with P to check Pending status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with P0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Pending
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

     # Submit a arrived declaration with LRN starting with I to check Declaration Handled Externally status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with J0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Declaration handled externally
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

     # Submit a arrived declaration with LRN starting with N to check Released status
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with N0 prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I navigate to Declaration Type page
    And I select a arrived declaration type
    And I click continue
    And I navigate to summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Released
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page

    # Print and View - Validate View or Print declaration page
    And I click on print or view link
    Then I should land on print-or-view page
    And I click back

    #  Cancellation - Unsuccessful cancellation.
    And I click on cancel declaration link
    Then I should land on Cancel-Declaration page
    And I select No longer required as the reason and enter description for cancellation
    And I click continue
    Then I should land on Cancel holding page and redirect to Cancellation result page
    Then I should land on Cancel-Result page
    And I navigate back to choice page
    And I should land on Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Released
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Cancellation request denied status on timeline

    # Cancellation - successful cancellation
    And I click on copy link
    Then I should land on copy declaration page
    And I enter ducr 8GB123456469274-101SHIP1 and lrn starting with G1S prefix
    And I click continue
    Then I should land on Saved-Summary page
    And I click continue on summary
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Submitted tab
    And I validate declaration details on Submitted tab and check Status is Arrived and accepted
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page
    And I click on cancel declaration link
    Then I should land on Cancel-Declaration page
    And I select No longer required as the reason and enter description for cancellation
    And I click continue
    Then I should land on Cancel holding page and redirect to Cancellation result page
    Then I should land on Cancel-Result page
    And I navigate back to choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I click on Cancelled & expired tab
    And I validate declaration details on Cancelled & expired tab and check Status is Cancelled
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Cancelled status on timeline

    # Below scenario -
    # 1.Checks saved draft declaration and removal of draft declaration

  Scenario: Check partial declarations saved on Saved Declarations and remove saved declaration
    Given I fill section1 for STANDARD, prelodged declaration
    And I click on Exit and comeback later link
    Then I should land on saved draft declaration page
    And I navigate to saved declarations
    Then I should land on Saved-Declarations page
    And I validate details on saved declarations page and check status is Draft
    And I remove saved Declaration
    Then I should land on Remove-Saved-Declaration page
    And I select No to remove saved declaration
    And I click continue
    Then I should land on Saved-Declarations page
    And I remove saved Declaration
    Then I should land on Remove-Saved-Declaration page
    And I select Yes to remove saved declaration
    And I click continue
    Then I should land on Saved-Declarations page