Feature: Section5 Standard Prelodged

  @Section5 @StandardPrelodged
  Scenario: exports standard declaration journey
    Given I fill section1
    And I fill section2
    And I fill section3
    And I fill section4
    Then I should land on Add-Declaration-Item-1 page
    And I select Add Item button
    Then I should land on Procedure-codes page
    And I select 1042 as procedure code
    And I click continue
    Then I should land on Additional-Procedure-Codes page
    And I select F75 as additional procedure code
    And I select 2ES as additional procedure code
    And I click continue
    Then I should land on Fiscal-Information page
    And I select Yes for Onward supply relief
    And I click continue
    Then I should land on Additional-Fiscal-References page
    And I select VAT registered country as Andorra : AD and VAT number as 1234
    And I click continue
    Then I should land on Additional-Fiscal-References-List page
    And I select Yes for adding more VAT details
    And I click continue
    Then I should land on Additional-Fiscal-References page
    And I select VAT registered country as Afghanistan : AF and VAT number as 1234
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
    Then I should land on National-Additional-Code page
    And I select Yes and enter A123 as national additional code
    And I click continue
    Then I should land on National-Additional-Codes-List page
    And I select Yes for adding another national code
    And I click continue
    Then I should land on National-Additional-Code page
    And I enter A125 as another national additional code
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
    And I select Yes on package information list page
    And I click continue
    Then I should land on Package-Information page
    And I enter Atomizer as package type, 30 as number of packages and Test Atomizer as shipping mark as second package info
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
    And I select Yes on additional information list page
    And I click continue
    Then I should land on Additional-Information page
    And I enter REJIM as code and REJIM Description as required information as second additional information
    And I click continue
    Then I should land on Additional-Information-List page
    And I select No on additional information list page
    And I click continue
    Then I should land on Licence-Required-YesNo page
    And I select Yes to check if the goods require a licence
    And I click continue
    Then I should land on Additional-Document page
    And I enter C501 as code and GBAEOC71757 as identifier as first additional document
    And I click continue
    Then I should land on Additional-Document-List page
    And I select No on additional document list page
    And I click continue
#    Then I should land on Additional-Document page
#    And I enter X002 as code and GBAEOC71758 as identifier as second additional document
#    And I click continue
#    Then I should land on Additional-Document-List page
#    And I select No on additional document list page
#    And I click continue
    Then I should land on Declaration-Items-List page
    And I select No on declaration items list page
    And I click continue
    Then I should land on MiniCYA-Section-5 page
    And I check the MiniCYA page for Section-5
    And I click continue on MiniCya





