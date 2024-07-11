@Pagination
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
    And I create 30 draft declarations