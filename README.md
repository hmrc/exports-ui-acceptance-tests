# exports-ui-acceptance-tests
These acceptance tests are written using ScalaTest and include smoke and regression tests for the following front-end and back-end services:
- customs-declare-exports-frontend
- customs-declare-exports

The acceptance tests can be run both locally and on Jenkins.
# Key Information
When changes have been made to the front-end or back-end services listed above, run the acceptance tests locally against your changes.
1. Stop the front-end and/or back-end services affected by your changes if they are currently running through sm2:
   - sm2 --stop CUSTOMS_DECLARE_EXPORTS_FRONTEND
   - sm2 --stop CUSTOMS_DECLARE_EXPORTS
2. Run the customs-declare-exports-frontend and customs-declare-exports services locally using:
   - sbt run
3. Verify that both the front-end and back-end services are running successfully.
4. Run the relevant acceptance test scenario against the locally running front-end and back-end services.
5. Once the changes have been approved, ensure that the Smoke Tests Jenkins job has run successfully.
6. If no changes have been made to the acceptance tests, the Regression Tests will not run automatically. In this case, run the regression tests manually.
7. For jenkins execution, see the [Jenkins Builds](#jenkins-builds) section for links to manually trigger the regression tests.

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
> **Note:** This script runs all scenarios in the test suite and therefore takes longer to complete. Where possible, use the appropriate test tags to run the relevant scenarios and get faster results.
```bash
   ./run_tag.sh @Regression
```

### Optional arguments of the test script:
Note that the order of the arguments is not relevant.

By default, the script runs the scenarios using the chrome browser. To run the script using a different browser, specify the browser as follows:
```bash
$ ./run_tag.sh firefox @Regression1  # chrome, edge or firefox
```

By default, the script runs against the local environment. To run the script against a specific environment, specify the environment as follows:
```bash
 
$ ./run_tag.sh staging @Smoke firefox  # local or staging
```

### Other ways of Running Tests
To run scenarios for specific journey types, use the appropriate tags:
```bash
 ./run_tag.sh  @Clearance     #The same approach can be used for other available journey types, such as Occasional, Simplified, Standard,Supplementary 
```

To run scenarios for specific sections of a journey, use the appropriate tags:
```bash
 ./run_tag.sh  @Section1      # The same approach can be used for other available sections, such as Section2, Section3, Section4, Section5, Section6
```

## Post-Merge Regression Testing
>**Important:** When acceptance tests are added or updated, run the relevant tests locally before raising a PR. Once the PR has been reviewed and the changes have been merged, ensure that the following Jenkins jobs have completed successfully:
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

The scenario documentation provides a reference for understanding the scope of acceptance test coverage and the user journeys validated by these tests.
- [[exports-ui-accpetance-tests-scenarios](https://confluence.tools.tax.service.gov.uk/spaces/BTL/pages/1398703349/exports-ui-acceptance-tests+-Testing+Scenarios+Coverage)]
