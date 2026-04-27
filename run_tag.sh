#!/bin/bash -e

usage() { printf "\nUsage: $0 [@<tag-id>]  [chrome | edge | firefox]  [local | dev | staging]\n\n" 1>&2; exit 1; }

Tag="Smoke"
Browser="chrome"
Environment="local"

for arg in "$@"; do
    [[ $arg = @* ]] && Tag="${arg#@}" || \
    case $arg in
        "chrome" | "edge" | "firefox") Browser=$arg ;;
        "local" | "dev" | "staging") Environment=$arg ;;
        *) usage; exit ;;
    esac
done

Runner="uk.gov.hmrc.test.ui.specs.${Tag}TestRunnerOrderSpec"

sbt clean \
   -Dbrowser=$Browser \
   -Denv=$Environment \
   -Dbrowser.option.headless=true \
   -Dbrowser.usePreviousVersion=true \
   "testOnly $Runner -- -n $Tag" testReport
