Feature: Section3 Standard Prelodged

  @Section3 @StandardPrelodged
  Scenario: exports standard declaration journey
    Given I fill section1
    And I fill section2
    Then I should land on Destination-Country page
    And I select Ukraine as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select Yes to provide routing countries
    And I click continue
    Then I should land on Countries-Of-Routing page
    And I add United States of America : The United States of America as a routing country
    And I add Chile : Chile as a routing country
    And I click continue
    Then I should land on Location-Of-Goods page
    And I select Yes to provide location as GBCUASDDOVAPF
    And I click continue
    Then I should land on Office-Of-Exit page
    And I select Aberdeen with code GB000434 as the office of exit
    And I click continue
    Then I should land on MiniCYA-Section-3 page
    And I check the MiniCYA page for Section-3
    And I click continue on MiniCya





