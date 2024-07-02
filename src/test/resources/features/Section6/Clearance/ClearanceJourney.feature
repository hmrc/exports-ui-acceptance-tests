@Regression3 @Smoke
Feature: Section6 Clearance Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
    # 3. The following pages are skipped
         #  Inland-Transport-details
         #  Border-Transport

  @Section6 @Clearance @Smoke
  Scenario: clearance journey section-6
    Given I clear data in cache
    Given I fill section1 for CLEARANCE,prelodged declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    Then I should land on Transport-Leaving-The-Border page
    And I select Sea transport as mode of transport leaving the border
    And I click continue
    Then I should land on Warehouse page
    And I select Yes and enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    Then I should land on Departure-Transport page
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
    And I select No to add another security seal
    And I click continue
    Then I should land on Container-List page
    And I select No to add another container
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

      ## Below scenario -
     # 1. isEidr is Yes and procedure code is 0017 with  Additional procedure code as 16M
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
          # Express Consignment
          # Transport-Payment
          # Containers page
    # 3. The following pages are skipped
         #  Inland-Transport-details
         #  Border-Transport

    Then I navigate to Entry Into Declarant Records page
    And I select No to is this an entry into declarant records
    And I click continue
    Then I navigate to Procedure codes page
    And I select 0017 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 16M as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Fixed transport installations as mode of transport leaving the border
    #Due to the fix transport installation we need to clear Departure transport
    And I clear cache for section 6
    And I click continue
    Then I should land on Warehouse page
    And I select Yes and enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    Then I should land on Express-Consignment page
    And I select Yes to confirm consignment as express
    And I click continue
    Then I should land on Transport-Payment page
    And I select Payment in cash as the mode of payment
    And I click continue
    Then I navigate to MiniCYA page for Section-6
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

 ## Below scenario -
     # 1. if procedure code is 1007 and Additional procedure code as 1CS
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
    # 3. The following pages are skipped
         # Transport-payment
         #  Inland-Transport-details
         #  Container/{container name}/ seals
         #  Containers/{container name}/ add-seal
         #  Containers/{container name}/ seals
         #  Containers

  @Section6 @Clearance
  Scenario: clearance arrived journey section-6
    Given I clear data in cache
    Given I fill section1 for CLEARANCE,arrived declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 1007 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 1CS as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Roll on Roll off (RoRo) as mode of transport leaving the border
    And I click continue
    Then I should land on Warehouse page
    And I select Yes and enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    Then I should land on Departure-Transport page
    And I select Ship IMO number as the departure transport
    And I click continue
    Then I should land on Express-Consignment page
    And I select No to confirm consignment as express
    And I click continue
    Then I should land on Container page
    And I select No to add containers
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page