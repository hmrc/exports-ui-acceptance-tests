Feature: Section6 Simplified Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Supervising-Customs-Office
     # 3 The following page is skipped
          # Departure Transport

  @Section6 @SimDec
  Scenario: simplified journey section-6
    Given I fill section1 for SIMPLIFIED,Prelodged declaration
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
    And I select Sea transport as mode of Inland transport
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

     ## Below scenario -
     # 1. if procedure code is 1007 and Additional procedure code as 000
     # 2. The following pages are visible
          # Warehouse Details
          # Supervising-Customs-Office
     # And landing on Inland-Or-Border page
    And I clear Presenting to customs keys from cache
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 1007 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Inland waterway transport as mode of transport leaving the border
    And I click continue
    Then I should land on Warehouse page
    And I enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     # Note : For the following procedure codes (1007) and (3171) the navigation has
                   # /transport-leaving-the-border
                   # /warehouse-details pages
         # For the procedure code (1040) the navigation has
                  #  /transport-leaving-the-border
                  #   /Inland-or-border pages
         # And for all other procedure codes user will see Supervising customs office and the navigation is
                  #  /transport-leaving-the-border
                  #   /supervising-customs-office

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
     # 2. The following page is skipped
          # Supervising-Customs-Office
          # Warehouse
     # And landing on Inland-Or-Border page

    # As the procedure code is changing to 1044, this will skip warehouse, so we clear the warehouse from cache.
    And I clear Warehouse ID keys from cache
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 1044 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 1CS as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Roll on Roll off (RoRo) as mode of transport leaving the border
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     ## Below scenario -
     # 1. if procedure code is 3171 and Additional procedure code as 000
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
     # 3 The following page is skipped
          # Departure Transport

  @Section6 @SimDec
  Scenario: simplified arrived journey section-6
    Given I fill section1 for SIMPLIFIED,arrived declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 3171 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Inland waterway transport as mode of transport leaving the border
    And I click continue
    Then I should land on Warehouse page
    And I enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBBTH001 as the customs office code
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Sea transport as mode of Inland transport
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
    And I select No to add another container
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page