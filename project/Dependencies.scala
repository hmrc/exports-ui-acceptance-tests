import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "com.typesafe"          % "config"          % "1.4.3"     % Test,
    "com.vladsch.flexmark"  % "flexmark-all"    % "0.64.8"    % Test,
    "org.scalatest"         %% "scalatest"      % "3.2.18"    % Test,
    "org.scalatestplus"     %% "selenium-4-12"  % "3.2.17.0"  % Test,
    "io.cucumber"           %% "cucumber-scala" % "8.21.0"    % Test,
    "io.cucumber"           % "cucumber-junit"  % "7.18.0"    % Test,
    "junit"                 % "junit"           % "4.13.2"    % Test,
    "com.novocode"          % "junit-interface" % "0.11"      % Test,
    "uk.gov.hmrc"           %% "ui-test-runner" % "0.45.0"    % Test,
    "io.cucumber"           %% "cucumber-scala" % "8.21.0"    % Test,
    "io.cucumber"           % "cucumber-junit"  % "7.18.0"    % Test,
    "junit"                 % "junit"           % "4.13.2"    % Test,
    "com.novocode"          % "junit-interface" % "0.11"      % Test,
    "org.slf4j"             % "slf4j-simple"    % "2.0.13"    % Test,
    "ch.qos.logback"        % "logback-classic" % "1.5.6"     % Test
  )

}
