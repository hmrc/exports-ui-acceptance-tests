@Regression3
Feature: Section6 Supplementary Journey

  Background:
    Given I clear data in cache
    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Supervising-Customs-Office
     # 3. And the follwing pages are skipped
          # Inland-or-boarder
          # Express-Consignment
          # Transport-Payment

  @Section6 @Supplementary @Smoke
  Scenario: supplementary journey section-6
    Given I fill section1 for SUPPLEMENTARY,eidr declaration
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
    Then I should land on Inland-Transport-details page
    And I select Sea transport as mode of Inland transport
    And I click continue
    Then I should land on Departure-Transport page
    And I select Ship IMO number as the departure transport
    And I click continue
    Then I should land on Border-Transport page
    And I select Vehicle registration as the border transport
    And I click continue
    Then I should land on Transport-Country page
    And I select Macao as the transport country
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
     # 1. Authorisation code as EXRR
     # 2. postal or email is selected in Transport leaving the border and Mode of inland transport
     # 3. It should land on Supervising-customs-office
     # 4. And navigate to Container page
     # 5. The following pages are skipped in this navigation
          # Departure transport
          # Transport Country
    And I clear Country of registration for the transport leaving the UK border, Transport leaving the border, Transport details at the border keys from cache
    And I navigate to Authorisation Choice page
    And I select Permanent as export procedure choice
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code EXRR and enter eori as GB744638982000
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    Then I navigate to Transport-Leaving-The-Border page
    And I should land on Transport-Leaving-The-Border page
    And I select Postal or mail as mode of transport leaving the border
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBABD001 as the customs office code
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Postal or mail as mode of Inland transport
    And I click continue
    Then I should land on Container-List page
    And I select No to add another container
    And I click continue
    And I navigate to MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

  ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
     # 2. The following page is skipped
          # Supervising-Customs-Office
          # Express-Consignment
          # Transport-Payment

  @Section6 @Supplementary
  Scenario: supplementary journey simplified section-6
    Given I fill section1 for SUPPLEMENTARY,simplified declaration
    And I fill section2
    And I fill section3
    And I fill section4
    And I fill section5
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Rail transport as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Or-Border page
    And I select Customs controlled location for presenting the goods to customs
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Air transport as mode of Inland transport
    And I click continue
    Then I should land on Departure-Transport page
    And I select Flight number as the departure transport
    And I click continue
    Then I should land on Border-Transport page
    And I select Vehicle registration as the border transport
    And I click continue
    Then I should land on Container page
    And I select No to add containers
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
     #  Transport leaving the border as RoRo and Inland transport as Postal or mail
     # 2. The following pages are skipped
          # Supervising-Customs-Office
          # Inland-Or-Border
          # Departure-Transport
          # Border-Transport
          # Transport-Country
          # Express-Consignment
          # Transport-Payment

    And I clear Presenting to customs, Transport details at the border, Transport leaving the border keys from cache
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Roll on Roll off (RoRo) as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Postal or mail as mode of Inland transport
    And I click continue
    Then I should land on Container page
    And I select No to add another container
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Supervising-Customs-Office
     # 3. And the follwing pages are skipped
          # Express-Consignment
          # Transport-Payment

  @Section6 @Supplementary
  Scenario: supplementary simplified journey section-6
    Given I fill section1 for SUPPLEMENTARY,simplified declaration
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
    Then I should land on Departure-Transport page
    And I select Ship IMO number as the departure transport
    And I click continue
    Then I should land on Border-Transport page
    And I select European vessel number (ENI) as the border transport
    And I click continue
    Then I should land on Transport-Country page
    And I select Macao as the transport country
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
     # 1. If Authorisation Code is FP and Destination country as Guernsey
     #    and procedure code is 3171 and Additional procedure code as 1CS
     # 2. The following pages are visible
          # Warehouse
          # Supervising-Customs-Office
          # Inland Transport details and
          # Container
     # 3. And the following pages are skipped
          # Inland or Border
          # Departure Transport
          # Transport country
          # Express-Consignment
          # Transport-Payment

    Then I clear Presenting to customs, Transport details at the border, Transport leaving the border, Country of registration for the transport leaving the UK border keys from cache
    And I navigate to Authorisation Choice page
    And I select Permanent as export procedure choice
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I click on remove link
    Then I should land on Authorisations-Remove page
    And I select Yes to remove authorisation
    And I click continue
    Then I should land on Authorisation-Required page
    And I select first Authorisation code FP and enter eori as GB744638982000
    And I click continue
    Then I should land on Authorisations-Required-List page
    And I select No to add another authorisation
    And I click continue
    And I navigate to Destination Country page
    Then I should land on Destination-Country page
    And I select Guernsey as the destination country
    And I click continue
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 3171 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 1CS as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Sea transport as mode of transport leaving the border
    And I click continue
    Then I should land on Warehouse page
    And I enter approved warehouse number
    And I click continue
    Then I should land on Supervising-Customs-Office page
    And I select GBABD001 as the customs office code
    And I click continue
    Then I should land on Inland-Transport-details page
    And I select Postal or mail as mode of Inland transport
    And I click continue
    Then I should land on Container-List page
    And I select No to add another container
    And I click continue
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page





