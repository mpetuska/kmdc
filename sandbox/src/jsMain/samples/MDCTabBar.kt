package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.tab.Content
import dev.petuska.kmdc.tab.Icon
import dev.petuska.kmdc.tab.Label
import dev.petuska.kmdc.tab.MDCTabAttrsScope
import dev.petuska.kmdc.tab.Tab
import dev.petuska.kmdc.tab.bar.MDCTabBar
import dev.petuska.kmdc.tab.bar.MDCTabBarAttrsScope
import dev.petuska.kmdc.tab.bar.onActivated
import dev.petuska.kmdc.tab.indicator.Icon
import dev.petuska.kmdc.tab.indicator.Indicator
import dev.petuska.kmdc.tab.indicator.MDCTabIndicator
import dev.petuska.kmdc.tab.indicator.MDCTabIndicatorTransition
import dev.petuska.kmdc.tab.indicator.Underline
import dev.petuska.kmdc.tab.onInteracted
import dev.petuska.kmdc.tab.scroller.Scroller
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.RangeControl

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
