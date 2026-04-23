import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "org.scalatestplus"     %% "selenium-4-12"  % "3.2.17.0"  % Test,
    "junit"                 % "junit"           % "4.13.2"    % Test,
    "com.novocode"          % "junit-interface" % "0.11"      % Test,
    "uk.gov.hmrc"           %% "ui-test-runner" % "0.54.0"    % Test,
    "com.novocode"          % "junit-interface" % "0.11"      % Test,
    "org.slf4j"             % "slf4j-simple"    % "2.0.17"    % Test
  )

}
