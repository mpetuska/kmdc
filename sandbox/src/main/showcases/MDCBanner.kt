package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.banner.*
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import sandbox.control.BooleanControl
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
        Icon(attrs = { mdcIcon() }) { ComposeText(MDCIcon.ErrorOutline.type) }
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
