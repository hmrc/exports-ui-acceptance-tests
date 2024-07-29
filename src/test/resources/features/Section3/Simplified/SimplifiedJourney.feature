@Regression1 @Regression
Feature: Simplified Journey Section 3

  Background:
  Given I clear data in cache

  # Below scenario - RoutingCountries:[No] , LocationOfGoods: [No]
  @Section3 @Simplified
 Scenario: Complete Routes and Locations section on Simplified declaration journey
    Given I fill section1 for STANDARD,prelodged declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Ukraine as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select No to provide routing countries
    And I click continue
    Then I should land on Location-Of-Goods page
    And I select No to provide location as GBCUASDDOVAPF
    And I click continue
    Then I should land on Office-Of-Exit page
    And I select Aberdeen with code GB000434 as the office of exit
    And I click continue
    Then I should land on MiniCYA-Section-3 page
    And I check the MiniCYA page for Section-3
    And I click continue on MiniCya

    # Below scenario - RoutingCountries:[No] , LocationOfGoods: [Yes]
  @Section3 @Simplified
  Scenario: Complete Routes and Locations section on Simplified Arrived declaration journey
    Given I fill section1 for SIMPLIFIED,arrived declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Ukraine as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select No to provide routing countries
    And I click continue
    Then I should land on Location-Of-Goods page
    And I select Heysham as the location
    And I click continue
    Then I should land on Office-Of-Exit page
    And I select Aberdeen with code GB000434 as the office of exit
    And I click continue
    Then I should land on MiniCYA-Section-3 page
    And I check the MiniCYA page for Section-3
    And I click continue on MiniCya
