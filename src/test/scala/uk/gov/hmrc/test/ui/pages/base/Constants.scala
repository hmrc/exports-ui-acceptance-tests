package uk.gov.hmrc.test.ui.pages.base

object Constants {

  val yes = "Yes"
  val no  = "No"

  val Common = "COMMON" // Used for the tariff expander only

  val Clearance     = "CLEARANCE"
  val Occasional    = "OCCASIONAL"
  val Simplified    = "SIMPLIFIED"
  val Standard      = "STANDARD"
  val Supplementary = "SUPPLEMENTARY"

  val Arrived   = "arrived"
  val Prelodged = "prelodged"

  val NonEidr = "simplified"
  val Eidr    = "eidr"

  // Generally we need to pass different values for a drop down and the cache
  // ex : for countries
  val enteredValue = 0
  val storedValue  = 1
}
