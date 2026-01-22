lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "exports-ui-acceptance-tests",
    version := "0.1.0",
    scalaVersion := "3.3.6",
    scalacOptions ++= scalacFlags,
    libraryDependencies ++= Dependencies.test,
    //The testOptions from SbtAutoBuildPlugin supports only ScalaTest. Resetting testOptions for Cucumber Tests.
    Test / testOptions := Seq.empty
  )

lazy val scalacFlags = Seq(
  "-feature",                // warn about misused language features
  "-Xfatal-warnings",        // warnings are fatal!!
)
