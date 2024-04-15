@Regression
Feature: Occasional Journey Section 3

  Background:
    Given I clear data in cache

  # Below scenario - RoutingCountries:[Yes] , LocationOfGoods: [No], Number of countries Added: [1]
  @Section3 @OcaDec
  Scenario: Complete Routes and Locations section on Occasional Prelodged declaration journey
    Given I fill section1 for OCCASIONAL,prelodged declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Canada as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select Yes to provide routing countries
    And I click continue
    Then I should land on Countries-Of-Routing page
    And I add Cape Verde  : Cape Verde as a routing country
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

    # Below scenario - RoutingCountries:[Yes] , LocationOfGoods: [Yes], Number of countries Added: [1]
  @Section3 @OcaDec
  Scenario: Complete Routes and Locations section on Occasional Arrived declaration journey
    Given I fill section1 for OCCASIONAL,arrived declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Canada as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select Yes to provide routing countries
    And I click continue
    Then I should land on Countries-Of-Routing page
    And I add Argentina  : Argentina as a routing country
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