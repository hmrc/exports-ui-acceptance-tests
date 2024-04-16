Feature: Full Standard Journey

  @FullStandardJourney @StandardPrelodged
  Scenario: Full Standard Journey
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

#    And I click on the Declaration status link
#    Then I should land on Submissions page
















