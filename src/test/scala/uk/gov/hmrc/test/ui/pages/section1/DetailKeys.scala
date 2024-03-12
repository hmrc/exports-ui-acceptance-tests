package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val Section1 = 1
  val Section1Title = "Section 1 of 6: Declaration details"

  val DeclarationEori: DetailKey = DetailKey("Your EORI number", Section1)
  //     /standard-or-other & /declaration-choice
  val DeclarationType: DetailKey = DetailKey("Declaration type", Section1)
  //    /type
  val AdditionalDeclarationType: DetailKey = DetailKey("Type of declaration", Section1)
  //    /trader-reference & /ducr-entry
  val Ducr: DetailKey = DetailKey("DUCR", Section1)
  //    /local-reference-number
  val Lrn: DetailKey = DetailKey("Your reference (LRN)", Section1)
  //    /link-to-mucr
  val LinkToMucr: DetailKey = DetailKey("Link to a MUCR", Section1)
  //    /enter-a-mucr
  val Mucr: DetailKey = DetailKey("MUCR", Section1)
}
