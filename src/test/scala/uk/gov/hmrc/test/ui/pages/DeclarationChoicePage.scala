/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DeclarationChoicePage extends BasePage {

  val url: String                = TestConfiguration.url("exports-frontend") + "/declaration/declaration-choice"
  val homePageTitle              = "Which type of declaration do you want to create? - Make an export declaration online - GOV.UK"

  val standardDeclaration = "STANDARD"
  val simplifiedOccasional = "OCCASIONAL"
  val authorisedSimplifiedDeclaration = "SIMPLIFIED"
  val clearanceDeclaration = "CLEARANCE"
  val supplementaryDeclaration = "SUPPLEMENTARY"
  var choicePageHashMap: Map[String, String] = HashMap[String, String]()

  def checkTitle(): Unit={
    DeclarationChoicePage.onPage(homePageTitle)
  }

  def selectOptionToCreateWhatTypeOfDeclaration(selectOption: String): Unit = {

    selectOption match {
      case "StandardDeclaration"   => findElement("id", standardDeclaration ).click()
      case "SimplifiedOccasional" => findElement("id", simplifiedOccasional).click()
      case "AuthorisedSimplifiedDeclaration" => findElement("id", authorisedSimplifiedDeclaration).click()
      case "ClearanceDeclaration" => findElement("id", clearanceDeclaration).click()
      case "SupplementaryDeclaration" => findElement("id", supplementaryDeclaration).click()
    }
    choicePageHashMap+= ("choicePageSelectionDetails" -> selectOption)
    submit()
  }
}
