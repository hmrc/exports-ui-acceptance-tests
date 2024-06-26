@Regression2
Feature: Section5 Supplementary Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. Checking Supplementary Eidr Journey
     # 2. Checking Skipping of VAT details page
     # 2. Adding Multiple Items
     # 3. validating Removal of items from Mini cya and Declaration Items List page
     # 4. Check Add Item link navigates to procedure code page
     # 5. Provide only commodity description

  @Section5 @Supplementary
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
    And I enter only description as Old St Andrews golf ball whisky on commodity details page
    And I click continue
    Then I should land on Dangerous-Goods-Code page
    And I select Yes to enter the code 1234 as dangerous goods
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
    And I enter Aerosol as package type, with 20 packages and 1234 as shipping mark for first package info
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
    And I enter C501 as code and GBAEOC71757 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select Yes on declaration items list page
    And I click continue


    # Adding second item
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 000 as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 28034008 and description as Old St Andrews golf ball whisky
    And I click continue
    Then I should land on Dangerous-Goods-Code page
    And I select No to enter dangerous goods
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
    And I enter Barrel as package type, with 119 packages and 1204 as shipping mark for first package info
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
    And I enter C401 as code and GBXEOC71757 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

    # Deleting item from minicya section-5 page
    And I remove one item from the declaration
    Then I should land on Remove-Declaration-Item page
    # return back to mini cya page when selecting no
    And I select No to remove first item
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I remove one item from the declaration
    And I select Yes to remove first item
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

    # Deleting item from Declaration Items List page
    And I click back on MiniCya section 5
    Then I should land on Declaration-Items-List page
    And I remove one item from declaration item list page
    And I select Yes to remove first item
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I should be displayed with a warning text to add items

    # check Add item link on mini cya
    And I click on Add Item link
    Then I should land on Add-Declaration-Item-1 page

   ## Below scenario -
    # 1. Finishing a Supplementary simplified Declaration
    # 2. Change Item details by clicking change link on declaration-items-list page after completing an item

  @Section5 @Supplementary @Smoke
  Scenario: Complete Items section on Supplementary Simplified declaration journey and Validate Changing Item Details
    Given I fill section1 for SUPPLEMENTARY,simplified declaration
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
    Then I should land on Commodity-Details page
    And I enter commodity details code as 90034003 and description as St Andrews golf ball whisky
    And I click continue
    And I navigate to Dangerous Goods Code page
    And I select Yes to enter the code 1234 as dangerous goods
    And I click continue
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
    And I enter Aerosol as package type, with 20 packages and 1234 as shipping mark for first package info
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
    And I select Yes to add additional information
    And I click continue
    Then I should land on Additional-Information page
    And I enter 00400 as code and EXPORTER as required information as first additional information
    And I click continue
    Then I should land on Additional-Information-List page
    And I select No on additional information list page
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select No to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter C501 as code and GBAEOC71757 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page

      # click change link and update existing item details
    And I change details of already added Item
    Then I should land on Procedure-codes page
    And I select 1044 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 1SW as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 95034005 and description as Straw for bottles
    And I click continue
    And I navigate to Dangerous Goods Code page
    And I select Yes to enter the code 1034 as dangerous goods
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select No for adding another national code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 1009 as statistical value
    And I click continue

    # clicking change Package-Information-List page  and update package information
    Then I should land on Package-Information-List page
    And I click change to update package information
    And I enter Basket as package type, with 11 packages and 456 as shipping mark for first package info
    And I click continue
    And I select No on package information list page
    And I click continue
    Then I should land on Commodity-Measure page
    And I enter gross weight as 580 and net weight as 706
    And I click continue
    Then I should land on Supplementary-Units page
    And I select Yes and enter 62 as supplementary units
    And I click continue

    # clicking change Additional-Information-List page  and update Additional information
    Then I should land on Additional-Information-List page
    And I click change to update Additional Information
    And I enter 00408 as code and DATAREADER as required information as first additional information
    And I click continue
    And I select No on additional information list page
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select Yes to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document-List page

      # clicking change Additional-Documentation-List page  and update Additional Documents
    And I click change to update Additional Documents
    And I enter 9104 as code and GBAEOC717992 as identifier for first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5


