@Regression
Feature: Section6 Clearance Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 00
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
#  3. The following pages are skipped
          # Inland-Or-Border
   # Inland-Or-Border
#  Inland-Transport-details
#  Border-Transport
#  Transport-Country

  @Section6 @ClrDec
  Scenario: clearance journey section-6
    Given I fill section1 for CLEARANCE,prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    Then I should land on Transport-Leaving-The-Border page
    And I select Sea transport as mode of transport leaving the border
    And I click continue

#    Then I should land on Warehouse page //bug
    And I select Yes and enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue

#    Then I should land on Departure-Transport page
    And I select Ship IMO number as the departure transport
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
    Then I should land on Seal page
    And I enter Seal2 as seal
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

















