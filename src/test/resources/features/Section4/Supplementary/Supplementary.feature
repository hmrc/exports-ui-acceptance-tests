@Regression2 @Regression
Feature: Section4 Supplementary Journey

  Background:
    Given I clear data in cache

    ## Below scenario -
     # 1. Invoices-And-Exchange-Rate-Choice:[No], Exchange Rate:[Yes], Previous Documents Added:[2]
     # 2. Check title on previous documents page when authorisation choice is Permanent
     # 3. Validating skipping Total-Package-Quantity page when destination country is Guernsey Or Jersey

  @Section4 @Supplementary
  Scenario: Complete Transactions section on Supplementary simplified declaration journey and validate dynamic title changes on previous documents page
    Given I fill section1 for SUPPLEMENTARY,simplified declaration
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
    And I select option as House removal
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

    # validate dynamic title change on previous documents page
    # check title on previous documents page when authorisation choice is Permanent with excise
    And I navigate to Authorisation Choice page
    And I select Permanent with excise as export procedure choice
    And I click continue
    And I navigate to Previous Documents page
    Then I should land on Previous-Document page

    # check title on previous documents page when authorisation choice is Temporary
    And I navigate to Authorisation Choice page
    And I select Temporary as export procedure choice
    And I click continue
    And I navigate to Previous Documents page
    Then I should land on Previous-Document page

    # validate skipping Total-Package-Quantity page when destination country is Guernsey and Invoice and exchange rate choice is No
    And I navigate to Destination Country page
    And I select Guernsey as the destination country
    And I click continue
    And I navigate to Nature Of Transaction page
    Then I should land on Nature-Of-Transaction page

    # validate skipping Total-Package-Quantity page when destination country is Jersey and Invoice and exchange rate choice is Yes
    And I navigate to Destination Country page
    And I select Jersey as the destination country
    And I click continue
    And I navigate to Invoices And Exchange Rate Choice page
    And I select Yes on invoices and exchange rate choice page
    And I click continue
    Then I should land on Nature-Of-Transaction page

    ## Below scenario -
     # 1. Invoices-And-Exchange-Rate-Choice:[No], Exchange Rate:[No], Previous Documents Added:[1]
     # 3. Validating skipping Total-Package-Quantity page when destination country is Guernsey Or Jersey

  @Section4 @Supplementary
  Scenario: Complete Transactions section on Supplementary eidr declaration journey
    Given I fill section1 for SUPPLEMENTARY,eidr declaration
    And I fill section2
    And I fill section3
    Then I should land on Invoices-And-Exchange-Rate-Choice page
    And I select No on invoices and exchange rate choice page
    And I click continue
    Then I should land on Invoices-And-Exchange-Rate page
    And I select currency code as GBP and Total amount as 567640 with an exchange rate as No
    And I click continue
    Then I should land on Total-Package-Quantity page
    And I select 2 for the total number of packages
    And I click continue
    Then I should land on Nature-Of-Transaction page
    And I select option as Non Commercial change
    And I click continue
    Then I should land on Previous-Document page
    And I select as first Document Commercial Invoice as code and 9GB123456782317-BH1433A61 as reference
    And I click continue
    Then I should land on Previous-Documents-list page
    And I select No on previous documents list page
    And I click continue
    Then I should land on MiniCYA-Section-4 page
    And I check the MiniCYA page for Section-4
    And I click continue on MiniCya

    # validate skipping Total-Package-Quantity page when destination country is Jersey and Invoice and exchange rate choice is Yes
    And I navigate to Destination Country page
    And I select Jersey as the destination country
    And I click continue
    And I navigate to Invoices And Exchange Rate Choice page
    And I select Yes on invoices and exchange rate choice page
    And I click continue
    Then I should land on Nature-Of-Transaction page


