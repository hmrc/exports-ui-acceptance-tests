# exports-ui-acceptance-tests
This Acceptance tests are written using ScalaTest and contains smoke / regression tests for the below front-end and backend services.
- customs-declare-exports-frontend
- customs-declare-exports

This acceptance tests can be run **locally**  and as well as **jenkins**.

# Key Information
When changes have been made to the above front end and backend services, execute this acceptance tests against your changes locally.
1. Stop the front-end and backend services based on the changes made, if currently running through 'sm2'
   - sm2 --stop CUSTOMS_DECLARE_EXPORTS_FRONTEND
   - sm2 --stop CUSTOMS_DECLARE_EXPORTS
2. run customs-declare-exports-frontend and customs-declare-exports service locally(sbt run)
3. Verify that the local frontend and backend is running successfully.
4. Execute the relevant acceptance test scenario against the local frontend amd backend.
5. Once changes hve been approved, make sure the **Smoke Tests** jenkins job has run successfully.
6. If no changes have been made to the acceptance tests,the regression tests will not run automatically.Please run regression tests manually.
7. For jenkins execution, see the [Jenkins Builds](#jenkins-builds) links to trigger the regression tests manually.

# How to run the Tests

### Pre-requisites

Run the services for CDS Exports:

```bash
$ sm2 --start CDS_EXPORTS_DECLARATION_ATS
```
## Testing Locally
Follow the steps below to run the acceptance tests locally.

### How to run the Smoke tests
```bash
$ ./run_tag.sh
```
You can also run the script with the following tag: 
```bash
$ ./run_tag.sh @Smoke
```

### How to run the Regression tests

1. To run regression scenarios for Sections 1, 2, and 3:
```bash
   ./run_tag.sh @Regression1
```
2.To run regression scenarios for Sections 4 and 5:
```bash
   ./run_tag.sh @Regression2
```
3. To run regression scenarios for Section 6, Amend, Dashboard, and Rejected Notifications:
```bash
   ./run_tag.sh @Regression3
```
4. To run all regression scenarios:
> **Note:** This script runs all scenarios in the test suite and takes a long time to complete, use the appropriate test tags where possible for faster results.
```bash
   ./run_tag.sh @Regression
```

### Optional arguments of the test script:
Note that the order of the arguments is not relevant.

By default, the script runs the Scenarios using the `chrome` browser. If you want to run the script on a different browser:
```bash
$ ./run_tag.sh firefox @Regression1  # chrome, edge or firefox
```

if you want to run the script in a specific environment (by default: local):
```bash
 
$ ./run_tag.sh staging @Smoke firefox  # local, dev or staging
```

### Other ways of Running Tests
To run Scenarios for specific type of journeys run the script with the following tags:
```bash
 ./run_tag.sh  @Clearance     #The same approach can be used with other available types of journey, such as Occasional, Simplified, Standard,Supplementary 
```

To run Scenarios for specific section journeys run the script with the following tags:
```bash
 ./run_tag.sh  @Section1      # The same approach can be used with other available sections, such as Section2, Section3, Section4, Section5, Section6
```

## Post-Merge Regression Testing
>**Important:** When acceptance tests have been added/updated, run tests locally before raising a PR. Once the PR has been reviewed and the changes has been merged, ensure the following jenkins jobs have completed successfully:
 ## Jenkins-builds
 - [exports-smoke-local](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-one-to-three/)
 - [exports-regression-section-one-to-three](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-one-to-three/)
 - [exports-regression-section-four-and-five](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-four-and-five/)
 - [exports-regression-section-six-and-common-tests](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-six-and-common-tests/)

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
This section provides links to the acceptance test scenarios covered by the automated test suite. 
The scenario documentation serves as a reference for understanding the scope of acceptance test coverage and the user journeys validated by the test suite.
- [[exports-ui-accpetance-tests-scenarios](https://confluence.tools.tax.service.gov.uk/spaces/BTL/pages/1398703349/exports-ui-acceptance-tests+-Testing+Scenarios+Coverage)]
