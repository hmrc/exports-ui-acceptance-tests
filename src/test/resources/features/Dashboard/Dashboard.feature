Feature: Validate Dashboard and Declaration Information

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

#    # Submit declaration with LRN starting with Q to check Query raised status
    And I click on copy link
    Then I should land on copy declaration page
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

    # Submit a Prelodged declaration with LRN starting with C to check Query raised status
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
    And I validate declaration details on Submitted tab and check Status is Declaration cleared
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

    # Validate EAD print view page

    And I click on EAD print view link
    Then I should land on EAD print view page
    And I click back

    # Validate View or Print declaration page
    And I click on print or view link
    Then I should land on print-or-view page
    And I click back

    #  perform cancel declaration
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
    And I validate declaration details on Submitted tab and check Status is Declaration cleared
    And I navigate to declaration information page after clicking on mrn link
    Then I validate Cancellation request denied status on timeline

    # make a copy of the declaration and change LRN to start with GOS to check sucsessfull cancellation

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
    Then I validate Cancellation status on timeline