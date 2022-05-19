package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.banner.Actions
import dev.petuska.kmdc.banner.Content
import dev.petuska.kmdc.banner.Graphic
import dev.petuska.kmdc.banner.Icon
import dev.petuska.kmdc.banner.MDCBanner
import dev.petuska.kmdc.banner.MDCBannerAttrsScope
import dev.petuska.kmdc.banner.PrimaryAction
import dev.petuska.kmdc.banner.SecondaryAction
import dev.petuska.kmdc.banner.Text
import dev.petuska.kmdc.banner.onClosed
import dev.petuska.kmdc.banner.onClosing
import dev.petuska.kmdc.banner.onOpened
import dev.petuska.kmdc.banner.onOpening
import sandbox.control.BooleanChoice
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
    BooleanChoice("Centered", ::centered)
    BooleanChoice("Mobile Stacked", ::mobileStacked)
    BooleanChoice("Open", ::open)
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
