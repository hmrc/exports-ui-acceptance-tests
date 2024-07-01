@Regression1
Feature: Supplementary Journey For Section 3

  Background:
    Given I clear data in cache

  # Below scenario - No routing and countries of routing pages, LocationOfGoods: [No], Number of countries Added: [1]
  @Section3 @Supplementary
  Scenario: Complete Routes and Locations section on Supplementary Simplified declaration journey
    Given I fill section1 for SUPPLEMENTARY,simplified declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Mauritania as the destination country
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

  # Below scenario - No routing and countries of routing pages, LocationOfGoods: [Yes], Number of countries Added: [1]
  @Section3 @Supplementary @Smoke
  Scenario: Complete Routes and Locations section on Supplementary Edir declaration journey
    Given I fill section1 for SUPPLEMENTARY,eidr declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Mauritania as the destination country
    And I click continue
    Then I should land on Location-Of-Goods page
    And I select Yes to provide location as GBAUABDABDABM
    And I click continue
    Then I should land on Office-Of-Exit page
    And I select Aberdeen with code GB000434 as the office of exit
    And I click continue
    Then I should land on MiniCYA-Section-3 page
    And I check the MiniCYA page for Section-3
    And I click continue on MiniCya