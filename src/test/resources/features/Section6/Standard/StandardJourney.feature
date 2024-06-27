@Regression3
Feature: Section6 Standard Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Supervising-Customs-Office

  @Section6 @Standard
  Scenario: standard journey section-6
    Given I fill section1 for STANDARD,prelodged declaration
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
    And I select Vehicle registration as the border transport
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

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
     # 2. The following page is skipped
          # Supervising-Customs-Office
     # And landing on Inland-Or-Border page
    And I clear Presenting to customs, Customs supervising office keys from cache
    And I navigate to Procedure codes page
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Sea transport as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Or-Border page
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
          # RoRo as transport leaving the border
     # 2. The following page is skipped
         # Inland or border
     # landing on Inland-Transport-details page

    And I clear Presenting to customs keys from cache
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Roll on Roll off (RoRo) as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Transport-details page
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
       # and Inland or border is border
     # 2. The following page is skipped
          # Inland-Transport-Details
     #3. it should land on landing on Departure-transport page

    And I clear Inland mode of transport, Transport leaving the border, Country of registration for the transport leaving the UK border keys from cache
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Rail transport as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Or-Border page
    And I select Border location for presenting the goods to customs
    And I click continue
    Then I should land on Departure-Transport page
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     ## Below scenario -
     # 1. if procedure code is 1040 and Additional procedure code as 000
          # and select Fixed Transport Installation as transport-leaving-the-border
     # 2. It should land on landing on Inland-or-border page
     # 3. It navigates to Express-Consignment
     # 4. The following pages are skipped
          # Departure Transport
          # Transport country
          # Border Transport
          # Container have any Security seals page (/containers/test/seals)
          # Add Security seals page
          # You have added Security seals page (/containers/test/seals)
          # You have added Continer page (/containers)


    And I clear Presenting to customs, Transport details at the border, Method of payment for transport, Security seals keys from cache
    And I navigate to Transport-Leaving-The-Border page
    Then I should land on Transport-Leaving-The-Border page
    And I select Fixed transport installations as mode of transport leaving the border
    And I click continue
    Then I should land on Inland-Or-Border page
    And I select Border location for presenting the goods to customs
    And I click continue
    Then I should land on Express-Consignment page
    And I select No to confirm consignment as express
    And I click continue
    And I navigate to MiniCYA page for Section-6
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I navigate to Container List page
    Then I should land on Container-List page
    And I click remove Container 0 on Container List page
    Then I should land on Remove-This-Container page
    # Remove the container
    And I select Yes to remove container Container1
    And I click continue
    And I click remove Container 0 on Container List page
    Then I should land on Remove-This-Container page
    And I select Yes to remove container Container2
    And I click continue
    Then I should land on Container page
    And I select No to add containers
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6

     ## Below scenario -
     # 1. if procedure code is 1042 and Additional procedure code as 000
     # 2. The following page is visible
          # Supervising-Customs-Office
     # This is full arrived journey which cover all the pages, by adding a seal to the container and remove the seal

  @Section6 @Standard @Smoke
  Scenario: standard arrived journey section-6
    Given I fill section1 for STANDARD,arrived declaration
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
    And I select Vehicle registration as the border transport
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
    # Remove the seal
    And I click on remove Seal 0 on Seal List page
    Then I should land on Remove-This-Seal page
    And I select Yes to remove seal Seal1
    And I click continue
    Then I should land on Seal-YesNo page
    And I select No to add security seal
    And I click continue
    And I select No to add another container
    And I click continue
    Then I should land on MiniCYA-Section-6 page
    And I check the MiniCYA page for Section-6
    And I click continue on MiniCya
    Then I should land on Saved-Summary page
    And I click change link for LRN page
    Then I should land on Lrn page
    # Scenario to cover External Amend functionality
    And I enter LRN U0LRN813131
    And I click save and return to summary
    And I check the section headings and click confirm and continue
    Then I should land on Submit-Your-Declaration page
    And I submit the declaration
    Then I should land on holding page and redirect to Confirmation page
    And I should land on Confirmation page
    And I navigate to Choice page
    And I select to Manage Submit Declaration
    Then I should land on Dashboard page
    And I validate declaration details on Submitted tab and check Status is Goods being examined
    And I navigate to declaration information page after clicking on mrn link
    Then I should land on Declaration-Information page
    And I validate details on declaration information page
   # For external amended declaration we are not displaying Amend link to user to Amend the declaration
   # Now we are showing copy declaration link to allow user to copy the External amend declaration
   And I validate that the Amend declaration link is not displayed and Copy declaration link is displayed
