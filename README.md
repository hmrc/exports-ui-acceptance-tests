**This is a template README.md.  Be sure to update this with project specific content that describes your ui test project.**

# exports-ui-acceptance-tests
`<digital service name>` UI journey tests.  

## Pre-requisites

### Services

Start Mongo Docker container as follows:

```bash
docker run --rm -d -p 27017:27017 --name mongo mongo:4.4
```

Start `<digital service name>` services as follows:

```bash
sm2 --start <profile>
```

### Dockerized browser container(s)

Start a browser Docker container as follows:

* Argument `<browser>` must be `remote-chrome`, `remote-edge` or `remote-firefox`.

```bash
./run_browser_with_docker.sh <browser>
```

### Test inspection and debugging

Connect to `127.0.0.1:5900` via a VNC client to inspect and debug test execution.

If prompted for a password the default is `secret`.

## Tests

Run tests as follows:

* Argument `<browser>` must be `chrome`, `edge`, `firefox`, `remote-chrome`, `remote-edge` or `remote-firefox`.
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.

```bash
./run_tests.sh <browser> <environment>
```

### Running ZAP tests

ZAP tests can be automated using the HMRC Dynamic Application Security Testing approach. Running 
automated ZAP tests should not be considered a substitute for manual exploratory testing using OWASP ZAP.

#### Tagging tests for ZAP

It is not required to proxy every journey test via ZAP. The intention of proxying a test through ZAP is to expose all the
 relevant pages of an application to ZAP. So tagging a subset of the journey tests or creating a 
 single ZAP focused journey test is sufficient.

#### Configuring the browser to proxy via ZAP 

Setting the system property `zap.proxy=true` configures the browser specified in `browser` property to proxy via ZAP. 
This is achieved using [webdriver-factory](https://github.com/hmrc/webdriver-factory#proxying-trafic-via-zap).

#### Executing a ZAP test

The shell script `run_zap_tests.sh` is available to execute ZAP tests. The script proxies a set of journey tests, 
tagged as `ZapTests`, via ZAP.  

For example, to execute ZAP tests locally using a Chrome browser

```
./run_zap_test.sh chrome local
```

To execute ZAP tests locally using a remote-chrome browser

```
./run_browser_with_docker.sh remote-chrome 
./run_zap_test.sh remote-chrome local
``` 

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment.

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

## Installing local driver binaries

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