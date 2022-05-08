package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.form.field.MDCFormField
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Text as ComposeText

object MDCBanner : Samples() {
  @OptIn(KMDCInternalAPI::class)
  override val content: SamplesRender = {
    Sample {
      var open by rememberMutableStateOf(true)
      var centered by rememberMutableStateOf(false)
      var mobileStacked by rememberMutableStateOf(false)
      Div {
        MDCFormField {
          MDCCheckbox(
            checked = centered,
            label = "Centered",
            attrs = { onInput { centered = !centered } }
          )
        }
        MDCFormField {
          MDCCheckbox(
            checked = mobileStacked,
            label = "Mobile Stacked",
            attrs = { onInput { mobileStacked = !mobileStacked } }
          )
        }
        MDCButton(
          text = if (open) "Close" else "Open",
          attrs = {
            onClick { open = !open }
          }
        )
      }
      Hr()
      Div {
        MDCBanner(
          open = open,
          centered = centered,
          mobileStacked = mobileStacked,
          attrs = {
            registerEvents()
            onOpening { open = true }
            onClosing { open = false }
          }
        ) {
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
    }
  }

  private fun MDCBannerAttrsScope.registerEvents() {
    onClosing { console.log("MDCBanner#onClosing", it.detail) }
    onClosed { console.log("MDCBanner#onClosed", it.detail) }
    onOpening { console.log("MDCBanner#onOpening", it.detail) }
    onOpened { console.log("MDCBanner#onOpened", it.detail) }
  }
}
