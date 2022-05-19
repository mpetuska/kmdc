package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
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
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.min
import org.jetbrains.compose.web.attributes.step
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Text

object MDCTabBar : Samples() {
  override val content: SamplesRender = {
    MDCTabIndicatorTransition.values().flatMap { t -> MDCTabIndicator.values().map { t to it } }
      .forEach { (transition, indicator) ->
        Sample("$transition - $indicator", "Play with controls to see different variations") {
          render(transition, indicator)
        }
      }
  }

  @Composable
  private fun render(transition: MDCTabIndicatorTransition, indicator: MDCTabIndicator) {
    var tabs by rememberMutableStateOf(5)
    var stacked by rememberMutableStateOf(false)
    var minnWidth by rememberMutableStateOf(false)
    Div {
      MDCTextField("$tabs",
        type = MDCTextFieldType.Outlined,
        label = "Tabs",
        attrs = {
          type(InputType.Number)
          value(tabs)
          step(1)
          min("0")
          onInput { it.value.toInt().let { v -> tabs = v } }
        })
      MDCFormField { MDCCheckbox(stacked, label = "Stacked", attrs = { onInput { stacked = it.value } }) }
      MDCFormField { MDCCheckbox(minnWidth, label = "Min Width", attrs = { onInput { minnWidth = it.value } }) }

    }
    Hr()
    var active by rememberMutableStateOf<String?>(null)
    MDCTabBar(attrs = {
      registerEvents()
      onActivated { active = it.detail.tabId }
    }) {
      Scroller {
        repeat(tabs) {
          val id = it + 1
          Tab(active = active == "mdc-tab-$id", stacked = stacked, minWidth = minnWidth, attrs = {
            registerEvents()
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
}
