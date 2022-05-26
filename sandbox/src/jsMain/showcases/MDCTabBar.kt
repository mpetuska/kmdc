package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.tab.*
import dev.petuska.kmdc.tab.bar.MDCTabBar
import dev.petuska.kmdc.tab.bar.MDCTabBarAttrsScope
import dev.petuska.kmdc.tab.bar.onActivated
import dev.petuska.kmdc.tab.indicator.*
import dev.petuska.kmdc.tab.scroller.Scroller
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.attributes.disabled
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.RangeControl

private class MDCTabBarVM {
  var transition by mutableStateOf(MDCTabIndicatorTransition.Slide)
  var indicator by mutableStateOf(MDCTabIndicatorType.Underline)
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
    ChoiceControl("Indicator", MDCTabIndicatorType.values().associateBy(MDCTabIndicatorType::name), ::indicator)
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
            Icon(attrs = { mdcIcon() }) { MDCIcon.DarkMode.type }
            Label("Tab $id")
          }
          Indicator(active = active == "mdc-tab-$id", transition = transition) {
            when (indicator) {
              MDCTabIndicatorType.Underline -> Underline()
              MDCTabIndicatorType.Icon -> Icon(attrs = { mdcIcon() }) { MDCIcon.Star.type }
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
