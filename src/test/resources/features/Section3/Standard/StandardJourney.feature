@Regression1 @Regression
Feature: Section3 Standard Journey

  Background:
    Given I clear data in cache

   # Below scenario - RoutingCountries:[Yes] , LocationOfGoods: [Yes], Number of countries Added: [2]
  @Section3 @Standard @Smoke
  Scenario: Complete Routes and Locations section on standard prelodged declaration journey
    Given I fill section1 for STANDARD,prelodged declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Mauritania as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select Yes to provide routing countries
    And I click continue
    Then I should land on Countries-Of-Routing page
    And I add Brazil : Brazil as a routing country
    And I add Czech Republic : Czech Republic as a routing country
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

  @Section3 @Standard
  Scenario: Complete Routes and Locations section on standard arrived declaration and also validate dynamic title changes on location of goods page
    Given I fill section1 for STANDARD,arrived declaration
    And I fill section2
    Then I should land on Destination-Country page
    And I select Mauritania as the destination country
    And I click continue
    Then I should land on Country-Of-Routing page
    And I select Yes to provide routing countries
    And I click continue
    Then I should land on Countries-Of-Routing page
    And I add Brazil : Brazil as a routing country
    And I add Czech Republic : Czech Republic as a routing country
    And I click continue
    Then I should land on Location-Of-Goods page
    And I click continue
    And I select Yes to provide location as GBCUASDDOVAPF
    And I click continue
    Then I should land on Office-Of-Exit page
    And I select Aberdeen with code GB000434 as the office of exit
    And I click continue
    Then I should land on MiniCYA-Section-3 page
    And I check the MiniCYA page for Section-3

    # change authorisation code to test dynamic title changes on location of goods page
    # check title on location of goods page when auth code is CSE
    Then I navigate to authorisations required list page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    And I select Yes to declare authorisations
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code CSE and enter eori as GB123456789006
    And I click continue
    Then I should navigate to Location Of Goods page

    # check title on location of goods page when auth code is EXRR
    Then I navigate to authorisations required list page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    And I select Yes to declare authorisations
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code EXRR and enter eori as GB123456789016
    And I click continue

    Then I should navigate to Location Of Goods page

    # check title on location of goods page when auth code is MIB
    Then I navigate to authorisations required list page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    And I select Yes to declare authorisations
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code MIB and enter eori as GB123456789206
    And I click continue
    Then I should navigate to Location Of Goods page



