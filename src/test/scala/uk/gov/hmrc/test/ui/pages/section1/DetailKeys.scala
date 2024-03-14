package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val section1 = 1
  val Section1: DetailKey = DetailKey("Section 1 of 6: Declaration details", section1, Some("references-card"))

  //    /gg-sign-in
  val DeclarationEori: DetailKey = DetailKey("Your EORI number", section1)
  //    /standard-or-other & /declaration-choice
  val DeclarationType: DetailKey = DetailKey("Declaration type", section1)
  //    /type
  val AdditionalDeclarationType: DetailKey = DetailKey("Type of declaration", section1)
  //    /trader-reference & /ducr-entry
  val Ducr: DetailKey = DetailKey("DUCR", section1)
  //    /local-reference-number
  val Lrn: DetailKey = DetailKey("Your reference (LRN)", section1)
  //    /link-to-mucr
  val LinkToMucr: DetailKey = DetailKey("Link to a MUCR", section1)
  //    /enter-a-mucr
  val Mucr: DetailKey = DetailKey("MUCR", section1)
}
