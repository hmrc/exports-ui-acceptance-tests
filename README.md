# exports-ui-acceptance-tests
This Acceptance tests are written using ScalaTest and contains smoke and regression tests for the below front-end and backend service.
- customs-declare-exports-frontend
- customs-declare-exports

This acceptance tests can be run **locally**  and are also executed as part of the **jenkin build** process.

### Front-End Testing
When changes have been made to the front end,it is good practice to run the front end locally and execute the relevant acceptance tests against local changes.
1. Stop the front-end service if currently running through 'sm2'
   sm2 --stop CUSTOMS_DECLARE_EXPORTS_FRONTEND
2. run customs-declare-exports-frontend service locally(sbt run)
3. Verify that the local front end is running successfully.
4. Execute the relevant acceptance test scenario against the local front end.

## How to run the Tests

### Pre-requisites

Run the services for CDS Exports:

```bash
$ sm2 --start CDS_EXPORTS_DECLARATION_ATS
```
## Testing Locally
Follow the steps below to run the acceptance tests locally.

### How to run Smoke tests only
```bash
$ ./run_tag.sh
```
You can also run the script with the following tag: 
```bash
$ ./run_tag.sh @Smoke
```

### How to run Regression tests only

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
> **Note:** This script runs all scenarios in the test suite and can take a long time to complete.To save time, use the appropriate test tags where possible.
```bash
   ./run_tag.sh @Regression
```

### Optional arguments of the `run_tag.sh` script:
Note that the order of the arguments is not relevant.

By default, the script runs the Scenarios using the `chrome` browser. If you want to run the script on a different browser:
```bash
$ ./run_tag.sh firefox @Regression  # chrome, edge or firefox
```

if you want to run the script in a specific environment (by default: local):
```bash
 
$ ./run_tag.sh staging @Smoke firefox  # local, dev or staging
```

###Other ways of Running Tests
To run Scenarios for specific journeys run the script with the following tags:
```bash
 ./run_tag.sh  @Clearance      # to run Clearance journey Scenarios
 ./run_tag.sh  @Occasional     # to run Occasional journey Scenarios
 ./run_tag.sh  @Standard       # to run Standard journey Scenarios
 ./run_tag.sh  @Simplified     # to run Simplified journey Scenarios
 ./run_tag.sh  @Supplementary  # to run Supplementary journey Scenarios
```

To run Scenarios for specific section journeys run the script with the following tags:
```bash
 ./run_tag.sh  @Section1      # to run Section1 journey Scenarios
 ./run_tag.sh  @Section2      # to run Section2 journey Scenarios
 ./run_tag.sh  @Section3      # to run Section3 journey Scenarios
 ./run_tag.sh  @Section4      # to run Section4 journey Scenarios
 ./run_tag.sh  @Section5      # to run Section5 journey Scenarios
 ./run_tag.sh  @Section6      # to run Section6 journey Scenarios
```

### Post-Merge Regression Testing
>**Important:** When acceptance tests have been added/updated, run tests locally before raising a PR. Once the PR has been reviewed and the changes has been merged, ensure the following jenkins jobs have completed successfully:
 - [[exports-smoke-local](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-one-to-three/)]
 - [[exports-regression-section-one-to-three](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-one-to-three/)]
 - [[exports-regression-section-four-and-five](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-four-and-five/)]
 - [[exports-regression-section-six-and-common-tests](https://build.tax.service.gov.uk/job/BordersAndTradeLiveServices/job/CDSExports/job/exports-regression-section-six-and-common-tests/)]

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
