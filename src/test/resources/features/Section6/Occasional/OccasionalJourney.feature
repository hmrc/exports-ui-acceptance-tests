@Regression
Feature: Section6 Occasional Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 00
     # 2. The following page is visible
          # Supervising-Customs-Office
     # 3. The following page is skipped
          # Departure Transport

  @Section6 @OcaDec
  Scenario: Occasional journey section-6
    Given I fill section1 for OCCASIONAL,prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    Then I should land on Transport-Leaving-The-Border page
    And I select Sea transport as mode of transport leaving the border
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    Then I should land on Inland-Or-Border page
    And I select Customs controlled location for presenting the goods to customs
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Air transport as mode of Inland transport
    And I click continue
    Then I should land on Border-Transport page
    And I select Ship or RoRo ferry IMO number as the border transport
    And I click continue
    Then I should land on Transport-Country page
    And I select Macao as the transport country
    And I click continue
    Then I should land on Express-Consignment page
    And I select Yes to confirm consignment as express
    And I click continue
    Then I should land on Transport-Payment page
    And I select Payment in cash as the mode of payment
    And I click continue
    Then I should land on Container page
    And I select Yes to add Container1 as container
    And I click continue
    Then I should land on Seal-YesNo page
    And I select Yes to add security seal
    And I click continue
    Then I should land on Seal page
    And I enter Seal1 as seal
    And I click continue
    Then I should land on Seal-List page
    And I select Yes to add another security seal
    And I click continue
    And I select No to add another security seal
    And I click continue
    Then I should land on Container-List page
    And I select Yes to add another container
    And I click continue
    And I enter Container2 container
    And I click continue
    Then I should land on Seal-YesNo page
    And I select No to add security seal
    And I click continue
    Then I should land on Container-List page
    And I select No to add another container
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

      ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 00
     # 2. The following page is visible
          # Supervising-Customs-Office
     # 3. The following page is skipped
          # Departure Transport

    @Section6 @OcaDec
    Scenario: Occasional arrived journey section-6
      Given I fill section1 for OCCASIONAL,arrived declaration
      And I fill section2
      And I fill section3
      And I fill section4
      And I fill section5
      Then I should land on Transport-Leaving-The-Border page
      And I select Sea transport as mode of transport leaving the border
      And I click continue
      Then I should land on Supervising-Customs-Office page
      And I select GBBTH001 as the customs office code
      And I click continue
      Then I should land on Inland-Or-Border page
      And I select Customs controlled location for presenting the goods to customs
      And I click continue
      Then I should land on Inland-Transport-details page
      And I select Air transport as mode of Inland transport
      And I click continue
      Then I should land on Border-Transport page
      And I select Flight number as the border transport
      And I click continue
      Then I should land on Transport-Country page
      And I select Macao as the transport country
      And I click continue
      Then I should land on Express-Consignment page
      And I select Yes to confirm consignment as express
      And I click continue
      Then I should land on Transport-Payment page
      And I select Payment in cash as the mode of payment
      And I click continue
      Then I should land on Container page
      And I select Yes to add Container1 as container
      And I click continue
      Then I should land on Seal-YesNo page
      And I select Yes to add security seal
      And I click continue
      Then I should land on Seal page
      And I enter Seal1 as seal
      And I click continue
      Then I should land on Seal-List page
      And I select No to add another security seal
      And I click continue
      Then I should land on Container-List page
      And I select Yes to add another container
      And I click continue
      And I enter Container2 container
      And I click continue
      Then I should land on Seal-YesNo page
      And I select No to add security seal
      And I click continue
      Then I should land on Container-List page
      And I select No to add another container
      And I click continue
      Then I should land on MiniCYA-Section-6 page
      And I check the MiniCYA page for Section-6
      And I click continue on MiniCya
      Then I should land on Saved-Summary page













