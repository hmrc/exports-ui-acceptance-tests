
# exports-ui-acceptance-tests
Smoke and regression tests for the `customs-declare-exports-frontend` service.  

## Pre-requisites

Run a Mongo Docker container:

```bash
$ docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:5.0
```

Run the services for CDS Exports:

```bash
$ sm2 --start CDS_EXPORTS_DECLARATION_ALL
```

## Tests
Run tests as follows:
- Argument `<browser>` must be `chrome`, `edge`, or `firefox`.
- Argument `<environment>` must be `local`, `dev` or `staging`.

Note that the `QA` environment uses real upstream services, so we do not run the tests in that environment.

```bash
$ sbt clean \
   -Dbrowser=$Browser \
   -Denv=$Environment \
   -Dcucumber.filter.tags=$Tag \
   "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner" testReport

```

### How to run Smoke tests only
```bash
$ ./run_tag.sh
```
You can also run the script with the following tag: 
```bash
$ ./run_tag.sh @Smoke
```

### How to run Regression tests only
```bash
$ ./run_tag.sh @Regression
```

### How to run specific tests
Add the `@Wip` tag to the Scenarios to test and run:
```bash
$ ./run_tag.sh @Wip
```

To run Scenarios for specific journeys run the script with the following tags: 
```bash
$ ./run_tag.sh  @Clearance      # to run Clearance journey Scenarios
$ ./run_tag.sh  @Occasional     # to run Occasional journey Scenarios
$ ./run_tag.sh  @Standard       # to run Standard journey Scenarios
$ ./run_tag.sh  @Simplified     # to run Simplified journey Scenarios
$ ./run_tag.sh  @Supplementary  # to run Supplementary journey Scenarios
```

### Optional arguments of the `run_tag.sh` script:
Note that the order of the arguments is not relevant.

By default the script runs the Scenarios using the `chrome` browser. If you want to run the script on a different browser:
```bash
$ ./run_tag.sh firefox @Regression  # chrome, edge or firefox
```

if you want to run the script in a specific environment (by default: local):
```bash
 
$ ./run_tag.sh staging @Smoke firefox  # local, dev or staging
```

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

## Installing locally browser driver binaries

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers. 

See the `drivers/` directory for some helpful scripts to do the installation work for you.  They should work on both Mac and Linux by running the following command:

    ./installGeckodriver.sh <operating-system> <driver-version>
    or
    ./installChromedriver <operating-system> <driver-version>

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome.  You can, however, however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter your password.*

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").

## Testing Scenarios Coverage

# Smoke Test

## Section 1

- **Running Standard Journey**: Covers all pages except supplementary ones.
- **Running Supplementary Journey**: Necessary because the consignment page is different from the rest of the journeys.

## Section 2

- **Running Standard Journey**: Covers all pages except for Clearance.
- **Running Clearance Journey**: Necessary because it includes the Entry into Declarant Record and IsExs pages, which are not part of other journeys.

## Sections 3 to 6

- **Running Standard Journey**: Covers all the pages.

## Common Journeys

- **Running Amend Journey**: Includes checking the Dashboard, Saved Declarations, and Amend Functionality.
- **Running DashBoard Journey**: Covers scenarios related Cancel declaration and Print link
- **Running Rejected Notification Journey**: Covers scenarios related to notification rejections.


## Regression

## Section 1

 **Standard & Clearance Journey** -
- User select DoYouHaveADucr value to Yes enters Ducr, Lrn and select Yes on Link-To-Mucr 

 **Occasional Journey** -
-  User select DoYouHaveADucr value to No Enters Trader-Reference, Select Yes on Confirm-Ducr, enters Lrn and select No on Link-To-Mucr page

**Simplified Journey** -
-  User select DoYouHaveADucr value to No Enters Trader-Reference, Select No on Confirm-Ducr, enters Ducr, Lrn and select Yes on Link-To-Mucr page

**Supplementary Journey** -
-  User completes simplified journey by providing MRN on consignment reference page
-  User completes eidr journey by providing EIDR date on consignment reference page

## Section 2

 **Standard Journey** -
 - User is not an exporter, not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number
 - User is an exporter and choose to move goods by using Third party carrier or haulier
 - User is an exporter and choose to use own transport
 - User is not an exporter and has Exporter EORI
 - User changes the holder of authorization from "Permanent" to "Permanent with excise"
 - user changes the authorisation choice from "Permanent with excise" to "Temporary"
 - User is not an exporter not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number with Arrived Journey

 **Clearance Journey** -
 - User is not an exporter, not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number
 - User is having the Entry into declarant records and navigates to Person Presenting Goods page then user shouldn't see the Declarant-Details and Are you the exporter pages
 - User is not having the Entry into declarant records and not an exporter then the user shouldn't see the On-Behalf-Of-Another-Agent page, representative-eori page and representative-type-agreed pages
 - User is having the Entry into declarant records and having the exporter EORI number and willing to provide security information then 
   the user shouldn't see the Are-you-the-exporter, Declarant details, are-you-completing-this-declaration-on-behalf-of-another-agent, representative-eori-number, representation-type-agreed pages
 - Clearance Arrived Journey - User is not having entry in declarant records is not an exporter,not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number and not willing to provide
   Security information with this combination the user navigates to Exporter-Address, Consingor-EORI-Number, Third-Party-Goods-Transportation, Consignee-Details, Is-Authorisation-Required pages 

 **Occasional Journey** -
 - User is not an exporter,not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number with both Arrived and Prelodged journeys

 **Simplified Journey** -
- User is not an exporter,not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number with both Arrived and Prelodged journeys

 **Supplementary Journey** -
 - User is not an exporter, not having EORI, not holding the contract to submit the declaration on behalf and not having the carrier EORI number, Supplementary Declaration doesn't contain Third party goods transportation page.
   this is for Simplified and Eidr journeys

## Section 3

**Standard** -
- User select RoutingCountries as Yes, Adds multiple countries and selects LocationOfGoods as Yes to complete section3 for prelodged declaration
- User completes section for arrived declaration and validate dynamic title changes on location of goods page

**Occasional Journey & Simplified Journey** -
-  User select RoutingCountries as Yes, Adds one country and selects LocationOfGoods as No to complete section3 for prelodged declaration
-  User select RoutingCountries as Yes, Adds one country and selects LocationOfGoods as Yes to complete section3 for arrived declaration

**Clearance Journey && Supplementary Journey** -
-  User skips Country-Of-Routing, Countries-Of-Routing pages and select LocationOfGoods as No to complete section3 for prelodged declaration
-  User skips Country-Of-Routing, Countries-Of-Routing pages and select LocationOfGoods as Yes to complete section3 for prelodged declaration

## Section 4

**Standard** -
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as Yes and adds two Previous Documents Added
- User select Invoices-And-Exchange-Rate-Choice as Yes and checks skipping of exchange rate page
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as No
- User checks skipping of Previous-Documents page when destination country is Jersey and Guernsey
- User completes section 4 for Standard Prelodged and Arrived declarations
- Removal of Previous Documents
- Checking Dynamic title update on previous documents pages based on authorisation code - Refer to Previous document page **title** method

**Occasional Journey**
- User completes section 4 for Occasional Prelodged and Arrived declarations

**Simplified Journey**
- User completes section 4 for Occasional Prelodged and Arrived declarations
- Checking Dynamic title update on previous documents pages based on authorisation code - Refer to Previous document page **title** method

 **Supplementary Journey**
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as Yes and adds two Previous Documents Added
- User select Invoices-And-Exchange-Rate-Choice as Yes and checks skipping of exchange rate page
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as No
- User checks skipping of Previous-Documents page when destination country is Jersey and Guernsey
- User completes section 4 for Standard Prelodged and Arrived declarations
- Checking Dynamic title update on previous documents pages based on authorisation code - Refer to Previous document page **title** method

**Supplementary Journey**
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as Yes and adds two Previous Documents Added
- User select Invoices-And-Exchange-Rate-Choice as Yes and checks skipping of exchange rate page
- User select Invoices-And-Exchange-Rate-Choice as No, Exchange Rate as No
- User checks skipping of Previous-Documents page when destination country is Jersey and Guernsey
- User completes section 4 for Standard Prelodged and Arrived declarations
- Checking Dynamic title update on previous documents pages based on authorisation code - Refer to Previous document page **title** method

**Clearance Journey**
- User completes section 4 for Occasional Prelodged and Arrived declarations
- Checking Dynamic title update on previous documents pages based on authorisation code and entry into declarant records - Refer to Previous document page **title** method

## Section 5

**Standard** -
- User Completes Standard Prelodged and Arrived Declaration.
- User verifies the "Check Items" section using the 1042 procedure code to enable Fiscal References pages.
- User ensures the display of the "CusCode" page post-entry of commodity code 2803400090.
- User validates the functionality to remove links on pages such as Additional Fiscal References, Nact Code, Package Information, Additional Information, and Additional Documents.
- User confirms the dynamic title change on the "Additional Documents" page when both "Authorisation code required documents" and "IsLicenseRequired" are set to "Yes."
- User opts for the "No" option on the Additional Fiscal References, Dangerous Goods, CusCode, Nact Code, Supplementary Units, Additional Information, and Additional Documents pages.
- User verifies the skipping of pages when the procedure code ranges from 1042 to 1040.
- User confirms the dynamic title change on the "Additional Documents" page when "Authorisation code required documents" is set to "Yes" and "isLicenseRequired" is set to "No."
- User tests the skipping functionality on the "Documents Required" page by selecting between yes/no options and verifies the visibility of the "Is Additional Documents Required" page.

- **Occasional Journey**
- User Completes Occasional Prelodged and Arrived Declaration.
- User Testing a low-value declaration by inputting the Additional Procedure Code "3LV."
- User Completes the Statistical and VAT Rating pages when the Additional Procedure code is "3LV." and validates skipping the Statistical page when the declaration is not low value.
- User Skips the Commodity Measurements and Supplementary Units page when the declaration type is set to "Occasional."
- User verifies page skipping when the procedure code is set to 1040 for an Occasional Journey, then switches the procedure code from 1040 to 1042 to review the Fiscal Information page of an Occasional Journey.
- User Updates details of Package Information, Additional Information, and Additional Documents by selecting the "Change" link on the respective list pages.
  
- **Simplified Journey**
- User Completes Simplified Prelodged and Arrived Declaration.
- User executes a low-value Simplified declaration with Additional Procedure Code "3LV" and populates Statistical and VAT Rating pages accordingly.
- User skips Commodity Measurements and Supplementary Units for Simplified declarations, and tests page skipping for procedure codes 1042 to 1040.
- User skips Statistical and VAT Rating pages for non-low-value declarations.
- User confirms dynamic title change on Additional Documents when "Authorisation code required documents" is "No" and "isLicenseRequired" is "Yes."
- User switches procedure code from 1040 to 1042 to review Fiscal Information in Simplified Journey.

**Supplementary Journey**
- User Completes Supplementary Simplified and Edir Declaration.
- User checks Supplementary Eidr Journey and verifies the skipping of VAT details page.
- User adds Multiple Items and validates the Removal of items from Mini CYA and Declaration Items List page.
- User checks if the Add Item link navigates to the procedure code page.
- User finishes a Supplementary Simplified Declaration and changes Item details by clicking the change link on the declaration-items-list page after completing an item.

**Clearance Journey**
- User Completes Clearance Prelodged and Arrived Declaration.
- User initiates a Clearance Prelodged Journey with IsEXS set to No in section 2, ensuring the skipping of the dangerous goods page, before updating IsEXS to Yes to validate the dangerous goods section.
- User performs a Clearance Arrived Journey when IsEXS is No in section 2, and selects procedure codes when EIDR in section 2 is No on an arrived declaration.
- Validate procedure codes when isEIDR is YES and NO

## Section 6

- **Standard**
- User completes Standard Prelodged dec with procedure code as 1042 and Additional procedure code as 000, to naviagate through Supervising customs office
- User completes Standard Prelodged dec with PC as 1040 and APC as 000, this will skip Supervising customs office and navigates through Inland Or Border page
- User completes Standard Prelodged dec with PC as 1040 and APC as 000, with RoRo as transport leaving the border, this will skip the Inland or Border page 
- User completes Standard prelodged dec with PC as 1040 and APC as 000 and Inland or Border as border, this will skip the Inland Transport Details page and includes Departure-Transport page
- User completes Standard prelodged dec with PC as 1040 and APC as 000 and use Fixed Transport Installation as Transport-leaving the border, this will navigates to Express-consignment by skipping Departure Transport and Transport country
- User completes Standard prelodged dec with PC as 1040 and APC as 000 and selects No for adding goods to container, this will skip all Container and Seals related pages
- User completes Standard arrived dec with PC as 1042 and APC as 000, this will include Supervising-customs-office in the flow. 

- **Occasional Journey**
- User completes Occasional prelodged dec with Procedure code as 1042 and Additonal Procedure Code as 000, to navigate through Supervising Customs office. 
- User completes Occastional prelodged dec with PC 1042 and APC 000, with destination country as Jersey and Inland and border as Border, this navigation flow will skip the Departure transport page.

- **Simplified Journey**
- User completes Simplified prelodged dec with Procedure Code as 1042 and Additional procedure code as 000, to navigate through Supervising customs office and for this declaration the navigation doesn't include Departure Transport page
- User completes Simplified prelodged dec with PC as 1007 and APC as 000, this navigates through Warehouse Details, with Supervising customs office and Inland or Border pages
- User completes Simplified prelodged dec with PC as 1044 and APC as 1CS, this navigates through Supervising customs office 
- User completes Simplified arrived dec with PC as 3171 and APC as 000, this navigates through Warehouse, Supervising-customs-office, Inland or border with Inland Transport details 

- **Supplementary Journey**
- User completes Supplementary Eidr dec with PC as 1042 and APC as 000, this will navigates through Supervising-customs-office and skips Inland-or-border, Express-Consigment and Transport-Payment pages
- User completes Supplementary Eidr dec with PC as 1042 and APC as 000, this by having Authorisation Code as EXRR and Transport leaving the border as RoRo then this will navigate to Supervising customs office
- User completes Supplementary Eidr dec with PC as 1042 and APC as 000, with Authorisation code as EXRR and Postal or email is selected as Transport leaving the border and Mode of Inland transport, this will navigate to Supervising customs office and lands on Container page
- User completes Supplementary Simplified dec with PC as 1040 and APC as 000, in this navigation Supervising Customs office, Express-consignment and Transport payment pages are skipped.
- User completes Supplementary Simplified dec with Authorisation Code as FP and Destination Country as Guernsey, with PC as 3171 and APC as 1CS, this will navigates through Warehouse, Supervising Customs Office, Inland Transpprt details and Container pages.

- **Clearance Journey**
  - User completes Clearance prelodged dec with Procedure code as 1042 and APC as 000, this navigates through Warehouse and Supervising customs office page
  - User completes Clearance prelodged dec with isEidr as yes, PC as 0017 and ASM as 16M this will skip Inland-transport-details and Border-transport page 
  - User completes Clearance arrived dec with PC 1007 and APC as 1CS, this navigates through warehouse and Supervising Customs Office and skips Inland-Transport-details, Transport payment and Container pages 

## DashBoard and Declaration Information

- **DashBoard and Declaration Scenarios**
  - Check various confirmation page titles and validates information on Dashboard and Declaration information pages
  - Validate Information on Dashboard and Declaration Information Pages
  - Validates View Print link and Ead Print link
  - Checks successful and unsuccessful Copy of a Declaration
  - Checks successful and unsuccessful Cancellation of a Declaration
  - Check Saved Declaration and removal of draft declarations

## Amend Scenarios
  - Amending complete section-2 Scenario.
  - Checking the error message while removing declaration item for submitted declaration.
  - Amending the declaration and adding a new item in Section-5
  - Exit and come back later and resuming the saved declaration
  - To verify rejected amend on Timeline page
  - To verify amendment cancellation on rejected amendments on Timeline page
  - To verify Failed Amendment in Timeline page
  - To verify Pending Amend declaration with Amendment requested notification on Timeline page

