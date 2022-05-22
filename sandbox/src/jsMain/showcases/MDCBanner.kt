package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.banner.*
import sandbox.control.*
import org.jetbrains.compose.web.dom.Text as ComposeText

private class MDCBannerVM {
  var open by mutableStateOf(true)
  var centered by mutableStateOf(false)
  var mobileStacked by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCBanner")
fun MDCBanner() = InteractiveShowcase(
  viewModel = { MDCBannerVM() },
  controls = {
    BooleanControl("Centered", ::centered)
    BooleanControl("Mobile Stacked", ::mobileStacked)
    BooleanControl("Open", ::open)
  },
) {
  MDCBanner(open = open, centered = centered, mobileStacked = mobileStacked, attrs = {
    registerEvents()
    onOpening { open = true }
    onClosing { open = false }
  }) {
    Content {
      Graphic {
        Icon(attrs = { classes("material-icons") }) { ComposeText("error_outline") }
      }
      Text("There was a problem processing a transaction on your credit card.")
    }
    Actions {
      PrimaryAction("Learn more")
      SecondaryAction("Fix it")
    }
  }
}

private fun MDCBannerAttrsScope.registerEvents() {
  onClosing { console.log("MDCBanner#onClosing", it.detail) }
  onClosed { console.log("MDCBanner#onClosed", it.detail) }
  onOpening { console.log("MDCBanner#onOpening", it.detail) }
  onOpened { console.log("MDCBanner#onOpened", it.detail) }
}
