#!/bin/bash -e
BROWSER=$1
ENVIRONMENT=$2

# Default values if not provided
BROWSER="${BROWSER:=chrome}"
ENVIRONMENT="${ENVIRONMENT:=local}"

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
#sbt scalafmtCheckAll scalafmtSbtCheck


sbt -Dbrowser="$BROWSER" -Denv="$ENVIRONMENT" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Regression" testReport
