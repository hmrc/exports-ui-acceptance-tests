Feature: Section5 Supplementary Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. Checking Supplementary Eidr Journey
     # 2. Checking Skipping of VAT details page
     # 2. Adding Multiple Items
     # 3. validating Removal of items
  @Section5 @SupDec
  Scenario: Complete Items section on Supplementary EIDR declaration journey
    Given I fill section1 for SUPPLEMENTARY,eidr declaration
    And I fill section2
    And I fill section3
    And I fill section4
    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1042 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F75 and 2ES and 1CD as additional procedure code
    And I click continue
    Then I should land on Fiscal-Information page
    And I select Yes for Onward supply relief
    And I click continue
    Then I should land on Additional-Fiscal-References page
    And I select VAT registered country as Andorra : AD and VAT number as 1234
    And I click continue
    Then I should land on Additional-Fiscal-References-List page
    And I select No for adding more VAT details
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 2803400090 and description as Old St Andrews golf ball whisky
    And I click continue
    Then I should land on Undangerous-Goods-Code page
    And I select Yes to enter the code 1234 as UN dangerous goods
    And I click continue
    Then I should land on Cus-Code page
    And I select Yes to enter the code 12345678 as CUS code
    And I click continue
    # skipped Vat rating page
    Then I should land on National-Additional-Code page
    And I select Yes and enter A123 as national additional code
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select No for adding another national code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 1080 as statistical value
    And I click continue
    Then I should land on Package-Information page
    And I enter Aerosol as package type, 20 as number of packages and 1234 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 500 and net weight as 710
    And I click continue
    Then I should land on Supplementary-Units page
    And I select Yes and enter 30 as supplementary units
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select Yes to add additional information
    And I click continue
    Then I should land on Additional-Information page
    And I enter 00400 as code and EXPORTER as required information as first additional information
    And I click continue
    Then I should land on Additional-Information-List page
    And I select No on additional information list page
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select Yes to check if the goods require a licence
    And I click continue
    # skipping of documents required yes/no page and landing on addition documents page
    Then I should land on Additional-Document page
    And I enter C501 as code and GBAEOC71757 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select Yes on declaration items list page
    And I click continue


    # Adding second item
    Then I should land on Procedure-codes page
    And I select 1042 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F75 as additional procedure code
    And I click continue
    Then I should land on Fiscal-Information page
    And I select No for Onward supply relief
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 2803400090 and description as Old St Andrews golf ball whisky
    And I click continue
    Then I should land on Undangerous-Goods-Code page
    And I select No to enter UN dangerous goods
    And I click continue
    Then I should land on Cus-Code page
    And I select No to enter CUS code
    And I click continue
    Then I should land on National-Additional-Code page
    And I select No to enter national additional code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 2000 as statistical value
    And I click continue
    Then I should land on Package-Information page
    And I enter Barrel as package type, 119 as number of packages and 1204 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 400 and net weight as 800
    And I click continue
    Then I should land on Supplementary-Units page
    And I select No to enter supplementary units
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select No to add additional information
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select No to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter C401 as code and GBXEOC71757 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5


   ## Below scenario -
    # 1. Checking Skipping of pages when procedure code is 1042 to 1040
    # 1. Checking Additional Documents Dynamic title when Authorisation code required documents is [Yes] and isLicenseRequired is [No]

  @Section5 @StdDec
  Scenario: Complete Items section on Supplementary Prelodged declaration journey and validate different page skipping scenarios
    Given I fill section1 for SUPPLEMANTRY,simplifed declaration
    And I fill section2
    And I fill section3
    And I fill section4
    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
#   validate skipping of fiscal information , additional-fiscal-references
    Then I should land on Commodity-Details page
    And I enter commodity details code as 9003400090 and description as St Andrews golf ball whisky
    And I click continue

  # skipping Cus Code Page when commodity details code doesnot end with 28,29,38 and VAT rating page when nature of transcation select option is not Goods being sold or Item purchased
    Then I navigate to Nature Of Transaction page
    And I select option as House removal
    Then I click continue
    And I navigate to Undangerous Goods Code page
    And I select Yes to enter the code 1234 as UN dangerous goods
    And I click continue
   # skipping Cus Code Page when commodity details code doesnot end with 28,29,38 and VAT rating page when nature of transcation select option is not Goods being sold or Item purchased
    Then I should land on National-Additional-Code page
    And I select Yes and enter A123 as national additional code
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select No for adding another national code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 1000 as statistical value
    And I click continue
    Then I should land on Package-Information page
    And I enter Aerosol as package type, 20 as number of packages and 1234 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 500 and net weight as 700
    And I click continue
    Then I should land on Supplementary-Units page
    And I select Yes and enter 12 as supplementary units
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select No to add additional information
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select No to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter C501 as code and GBAEOC71757 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5
