package local.sandbox.samples

import dev.petuska.kmdc.tab.indicator.Content
import dev.petuska.kmdc.tab.indicator.MDCTabIndicator
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
@EagerInitialization
private val samples = Samples("MDCTabIndicator") {
  Sample("Sliding", "underline") {
    MDCTabIndicator(active = true) {
      Content(indicator = MDCTabIndicator.Underline)
    }
  }
  Sample("Sliding", "icon") {
    MDCTabIndicator(active = true) {
      Content(indicator = MDCTabIndicator.Icon, attrs = { classes("material-icons") }) { Text("star") }
    }
  }
  Sample("Fading", "underline") {
    MDCTabIndicator(active = true) {
      Content(indicator = MDCTabIndicator.Underline)
    }
  }
  Sample("Fading", "icon") {
    MDCTabIndicator(active = true) {
      Content(indicator = MDCTabIndicator.Icon, attrs = { classes("material-icons") }) { Text("star") }
    }
  }
}
