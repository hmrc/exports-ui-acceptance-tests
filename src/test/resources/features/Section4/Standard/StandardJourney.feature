Feature: Section4 Standard Prelodged

  @Section4 @StandardPrelodged
  Scenario: exports standard declaration journey
    Given I fill section1
    And I fill section2
    And I fill section3
    Then I should land on Invoices-And-Exchange-Rate-Choice page
    And I select No on invoices and exchange rate choice page
    And I click continue
    Then I should land on Invoices-And-Exchange-Rate page
    And I select currency code as GBP and Total amount as 567640 with an exchange rate as 1.25
    And I click continue
    Then I should land on Total-Package-Quantity page
    And I select 4 for the total number of packages
    And I click continue
    Then I should land on Nature-Of-Transaction page
    And I select option as Goods being sol
    And I click continue
    Then I should land on Previous-Document page
    And I select as first Document Commercial Invoice as code and 9GB123456782317-BH1433A61 as reference
    And I click continue
    Then I should land on Previous-Documents-list page
    And I select Yes on previous documents list page
    And I click continue
    And I select as second Document Packing List as code and 9GB12345678899 as reference
    And I click continue
    Then I should land on Previous-Documents-list page
    And I select No on previous documents list page
    And I click continue
    Then I should land on MiniCYA-Section-4 page
    And I check the MiniCYA page for Section-4
    And I click continue on MiniCya





