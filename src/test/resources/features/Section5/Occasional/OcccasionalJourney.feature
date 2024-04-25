Feature: Section5 Occasional Journey

  Background:
    Given I clear data in cache

     ## Below scenario -
    # 1. Performing a low value declaration by providing Additional Procedure Code "3LV"
    # 2. Fill Statistical page and Vat rating page when Additional Procedure code is 3LV
    # 3. Skipping Commodity Measurements and Supplementary Units page when dec type is Occasional

  @Section5 @SimDec
  Scenario: Perform a Low Value Occasional Arrived Declaration
    Given I fill section1 for OCCASIONAL,arrived declaration
    And I fill section2
    And I fill section3
    And I fill section4

    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1040 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select 3LV as additional procedure code
    And I click continue
    Then I should land on Commodity-Details page
    And I enter commodity details code as 8411110000 and description as Aircraft engine
    And I click continue
    And I navigate to Undangerous Goods Code page
    And I select Yes to enter the code 1204 as UN dangerous goods
    And I click continue
    Then I should land on VAT-Rating page
    Then I select Yes option as goods being VAT zero-rated
    And I click continue
    Then I should land on National-Additional-Code page
    And I select Yes and enter A103 as national additional code
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select No for adding another national code
    And I click continue
    Then I should land on Statistical-Value page
    And I enter 1300 as statistical value
    And I click continue
    Then I should land on Package-Information page
    And I enter Basin as package type, 100 as number of packages and 104 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page
    And I select No on package information list page
    And I click continue
  # Skipped Commodity Measurements and Supplementary Units
    Then I should land on Additional-Information-YesNo page
    And I select No to add additional information
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select Yes to check if the goods require a licence
    And I click continue
    # skipped of documents required yes/no page
    Then I should land on Additional-Document page
    And I enter X002 as code and GBAEOC717572504502801 as identifier as first additional document
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
    # 1. Checking Skipping of pages when procedure code is 1042 to 1040 for Occasional Journey
    # 2. Skipping of Statistical page when declaration is not low value (using 000 additional procedure code)
    # 5. Change procedure code from 1040 to 1042 to check Fiscal-Information page of Occasional Journey
    # 6. Update details of Package Information, Additional Information and Additional Documents by clicking change link on list pages

  @Section5 @SimDec
  Scenario: Complete Items section on with Low Value Occasional Prelodged declaration and check change link
            functionality on Package Information, Additional Information and Additional Documents list pages
    Given I fill section1 for SIMPLIFIED,prelodged declaration
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
    # skipped fiscal information , additional-fiscal-references
    Then I should land on Commodity-Details page
    And I enter commodity details code as 2803400090 and description as St Andrews golf ball whisky
    And I click continue
    And I navigate to Undangerous Goods Code page
    And I select Yes to enter the code 1204 as UN dangerous goods
    And I click continue
    Then I should land on Cus-Code page
    And I select Yes to enter the code 12345678 as CUS code
    And I click continue

    # skipped Vat Details
    Then I should land on National-Additional-Code page
    And I select Yes and enter A103 as national additional code
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select No for adding another national code
    And I click continue

  # Skipping Statistical-Value when additional procedure code is not a low value declaration "3LV"
    Then I should land on Package-Information page
    And I enter Aerosol as package type, 10 as number of packages and 1034 as shipping mark as first package info
    And I click continue
    Then I should land on Package-Information-List page

    # clicking change Package-Information-List page  and update package information
    And I click change to update package information
    And I enter Basket as package type, 11 as number of packages and 1224 as shipping mark as first package info
    And I click continue
    And I select No on package information list page
    And I click continue
    Then I should land on Additional-Information-YesNo page
    And I select Yes to add additional information
    And I click continue
    Then I should land on Additional-Information page
    And I enter 00400 as code and EXPORTER as required information as first additional information
    And I click continue
    Then I should land on Additional-Information-List page

    # clicking change Additional-Information-List page  and update Additional information
    And I click change to update Additional Information
    And I enter 00401 as code and IMPORTER as required information as first additional information
    And I click continue
    And I select No on additional information list page
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select Yes to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter X002 as code and GBAEOC717572504502801 as identifier as first additional document
    And I click continue

    # clicking change Additional-Documentation-List page  and update Additional Documents
    And I click change to update Additional Documents
    And I enter X002 as code and GBAEOC717572504502801 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5

    # check Fiscal Reference page when Procedure code is 1042
    And I navigate to Procedure codes page
    And I select 1042 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F75 as additional procedure code
    And I click continue
    Then I should land on Fiscal-Information page
    And I select Yes for Onward supply relief
    And I click continue
    Then I should land on Additional-Fiscal-References page
    And I select VAT registered country as Andorra : AD and VAT number as 1234
    And I click continue
    And I navigate to MiniCYA page for Section-5
    And I check the MiniCYA page for Section-5

