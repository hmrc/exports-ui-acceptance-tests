##
##
#Scenario: To successfully submit standard prelodged journey
#   Given As a user I select journey with eori, ducr, lrn to complete declaration details section
#| journey  | eori           | ducr                        | lrn          |
#| standard | <eori> | 	<ducr>  | <lrn> |
#   When I complete filling the information for parties section involved with <areYouAnExporter>,<doYouKnowTheEori>,<authorisationChoice>,<isAuthorisationRequired> and <addAuthorisationRequired>
#| areYouAnExporter | doYouKnowTheEori | authorisationChoice | isAuthorisationRequired | addAuthorisationRequired |
#| yes              |
#   And I complete filling the routes and locations section with <goodsPassThroughOtherCountries>, <locationOfGoods>
#   And I complete filling the transactions section with <invoicesAndExchangeRateChoice>
#   And I complete filling the items that are required for the declaration with <procedureCode>,<additionalProcedureCode>,<commodityCode>,<is-additional-information-required>,<isLicenceRequired>
#   And I complete filling transport section with <transport-leaving-the-border>,<inland-transport-details>,<transport-country>,<express-consignment>,<container>
#   Then I submit the declaration with all the valid data to see the confirmation page
#
#  Examples:
#   | eori |
#
#
#  Examples:
#
#  Examples:
#    | goodsPassThroughOtherCountries | locationOfGoods |
#  Examples:
#    | invoicesAndExchangeRateChoice |
#  Examples:
#    | procedureCode | additionalProcedureCode | commodityCode | is-additional-information-required | isLicenceRequired |
#  Examples:
#    | transport-leaving-the-border | inland-transport-details | transport-country |
#
##Scenario Outline : To change the parties section pages data
##  Given I load the declaration to mongo with <eori>
##  When I load the declaration with ducr
##  And click <pageToNavigate> change link
##  Then validate the data in are you exporter page and change to option to No
##  Then continue journey with <exporterEoriNumber>,<areYouCompleteingDeclarationOnBehalfOfOtherAgent>,<carrierEoriNumber>,<otherPartiesInvolved>,<authorisationChoice>
##
##Examples:
##   | eori           | pageToNavigate   |
##   | GB757002374000 | areYouExporter   |
##Examples:
##   |exporterEoriNumber | areYouCompletetingDeclarationOnBehalfOfOtherAgent | carrierEoriNumber | otherPartiesInvolved |
##
##Scenario Outline : To change the Routing of Goods section pages data
##Given I load the declaration to mongo with <eori>
##When I load the declaration with ducr
##And click <pageToNavigate> change link
##Then validate the data in are you exporter page and change to option to Yes
##Then continue journey with <countriesOfRounting>
##
##Examples:
##  | eori           | pageToNavigate   |
##  | GB757002374000 | routingCountries |
##Examples:
##  | countriesOfRouting |
##  | Andora             |
