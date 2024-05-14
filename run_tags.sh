#!/bin/bash -e

Tag=$1
Browser=$2
Environment=$3

# Default values if not provided
BROWSER="${Browser:=chrome}"
ENVIRONMENT="${Environment:=local}"

[[ -z "${Tag}" ]] && TestTag="@Wip" || TestTag="${Tag}"

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
#sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Dbrowser=$BROWSER \
    -Denv=$ENVIRONMENT \
    -Dcucumber.filter.tags=$TestTag \
    "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner"
