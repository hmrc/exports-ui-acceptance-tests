@wip
Feature: StandardPrelodged Journey Happy Path With Procedure Code as 1040 and Additional Procedure Code as 000, Transport leaving the border as Sea Transport
         by selecting the Border

  Scenario: To successfully submit standard prelodged journey
    Given I navigate to login stub page and provide enrolment key, eori as GB757002374003 with exports redirect url to navigate to choice page
      And I select CreateDeclaration to create StandardDeclaration prelodged
      And I select the option No for Arrived export declaration
      And choose declarant details as Yes
      And I provide the ducr details
      And I provide the LRN details and DUCR details
      And I select Yes for Link to MUCR and enter MCUR Details
      And I choose Yes for the exporter details and provide the carrier and consignee details address
      And I select option for other parties involved as "No_other_parties_are_involved"
      And I select authorisation choice as "Permanent_export_of_UK_goods"
      And I select is_authorisation_required as Yes
      And I provide the details for authorisation with ACE and select hold the authorisation option as UserEori
      And I select "No" for adding another authorisation
      And I select the destination country as CD
      And I select No for country of routing
      And I select No and enter location of goods as GBAUMNCMANMNC
      And I select office of exit as Aberdeen
      And I select No for invoice and exchange rate choice page
      And I entered currencycode as GBP and Total amount invoiced as 5009933 and opted Yes with 1.25 for invoice or contract rate
      And I entered the total number of packages as 10
      And I select nature of transaction option as Goods Being Sold
      And I enter document code and document reference and No option for adding another document
      And I start adding the declaration item with the procedure code as 1040 and additional procedure code as 000
      And I select the commodity code and enter the item details information
      And I select No option for undangerous goods code and additional tarric code
      And I select vat rating page option as Yes
      And I select No for national additional code
      And I provide statistical value of this item as 1000
      And I enter the package details information and select No for adding another package details
      And I provide gross and net weight
      And I select Yes to add supplementary units
      And I select No for Additional information statements
      And I select Yes for Do you require a licence and provide the license details
      And I select No for adding another document reference
      And I select No for adding another item
      And I select Sea transport as transport leaving the border
      And I select Border option for inland or border page
      And I provide Ship name details for departure transport
      And I provide the transport country details
      And I select Yes for express consignment
      And I select Electronic funds transfer option for transport payment
      And I select Yes option to add the container and provide security seals details
      And I validate the details entered for declaration in summary page


