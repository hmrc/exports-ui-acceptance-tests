@Regression3 @Smoke
Feature: Validate Rejected Notifications

  Scenario: Fix a rejected declaration and submit the declaration
    Given I fill section1 for STANDARD, prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I fill section6
    And I navigate to Lrn page
    And I enter LRN BCDSCOM02
    And I click continue
    And I navigate to summary page
    Then I should land on Saved-Summary page
    And I check the section headings and click confirm and continue
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to rejected notification page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I validate declaration details on Rejected tab and check Status is Declaration rejected
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page
    And I fix errors on the declaration
    And I should land on Rejected-Notifications page

    # validate Lrn Page
    And I validate Lrn error details on rejected notifications
    Then I click on Lrn change link to fix error
    And I enter LRN MCDSCOM06
    And I return back to errors page
    And I check updated Lrn error details on rejected notifications
    And I navigate to check you answer from rejected notification page
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

    # Duplicate ducr warning messages check
    And I click on copy link
    And I enter ducr 8GB123456469274-101SHIP1 and a rejected lrn
    And I click continue
    And I click continue on summary
    And I submit the declaration
    Then I should land on holding page and redirect to rejected notification page
    And I validate ducr warning on rejected notifications page
    Then I click on Ducr change link to fix error
    And I validate duplicate ducr warning on ducr entry page
