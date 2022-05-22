package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.tab.*
import dev.petuska.kmdc.tab.bar.*
import dev.petuska.kmdc.tab.indicator.*
import dev.petuska.kmdc.tab.scroller.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*

private class MDCTabBarVM {
  var transition by mutableStateOf(MDCTabIndicatorTransition.Slide)
  var indicator by mutableStateOf(MDCTabIndicator.Underline)
  var disabled by mutableStateOf(false)
  var stacked by mutableStateOf(false)
  var minWidth by mutableStateOf(false)
  var tabs by mutableStateOf(5)

  var active by mutableStateOf<String?>(null)
}

@Composable
@Showcase(id = "MDCTabBar")
fun MDCTabBar() = InteractiveShowcase(
  viewModel = { MDCTabBarVM() },
  controls = {
    ChoiceControl(
      title = "Transition",
      options = MDCTabIndicatorTransition.values().associateBy(MDCTabIndicatorTransition::name),
      selected = ::transition
    )
    ChoiceControl("Indicator", MDCTabIndicator.values().associateBy(MDCTabIndicator::name), ::indicator)
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Stacked", ::stacked)
    BooleanControl("Min Width", ::minWidth)
    RangeControl("Tabs", ::tabs, converter = Number::toInt, min = 1, max = 20)
  },
) {
  MDCTabBar(attrs = {
    registerEvents()
    onActivated { active = it.detail.tabId }
  }) {
    Scroller {
      repeat(tabs) {
        val id = it + 1
        Tab(active = active == "kmdc-tab-$id", stacked = stacked, minWidth = minWidth, attrs = {
          registerEvents()
          if (disabled) disabled()
        }) {
          Content {
            Icon(attrs = { classes("material-icons") }) { Text("dark_mode") }
            Label("Tab $id")
          }
          Indicator(active = active == "mdc-tab-$id", transition = transition) {
            when (indicator) {
              MDCTabIndicator.Underline -> Underline()
              MDCTabIndicator.Icon -> Icon(attrs = { classes("material-icons") }) { Text("star") }
            }
          }
        }
      }
    }
  }
}

private fun MDCTabBarAttrsScope.registerEvents() {
  onActivated { console.log("MDCTabBar::onActivated", it.detail) }
}

private fun MDCTabAttrsScope.registerEvents() {
  onInteracted { console.log("MDCTab::onInteracted", it.detail) }
}
