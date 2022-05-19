package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.loremIpsum
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonType
import dev.petuska.kmdc.tooltip.MDCRichTooltip
import dev.petuska.kmdc.tooltip.MDCTooltip
import dev.petuska.kmdc.tooltip.MDCTooltipAction
import dev.petuska.kmdc.tooltip.MDCTooltipActions
import dev.petuska.kmdc.tooltip.MDCTooltipContent
import dev.petuska.kmdc.tooltip.MDCTooltipLink
import dev.petuska.kmdc.tooltip.MDCTooltipTitle
import dev.petuska.kmdc.tooltip.tooltipId
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanChoice
import sandbox.control.NamedBlock

private class MDCTooltipVM {
  var interactive by mutableStateOf(false)
  var persistent by mutableStateOf(false)
  val baseTooltipId = "kmdc-tooltip-id-"

  @Composable
  fun AnchorButton(tid: String) {
    MDCButton(
      text = "Hover over me",
      type = MDCButtonType.Raised,
      attrs = {
        tooltipId(tid)
      }
    )
  }
}

@Composable
@Showcase(id = "MDCTooltip")
fun MDCTooltip() = InteractiveShowcase(
  viewModel = { MDCTooltipVM() },
  controls = {
    BooleanChoice("Interactive", ::interactive)
    BooleanChoice("Persistent", ::persistent)
  },
) {
  NamedBlock("Simple") {
    val tid = "$baseTooltipId-simple"
    AnchorButton(tid)
    MDCTooltip(
      id = tid,
      persistent = persistent,
      text = loremIpsum
    )
  }
  NamedBlock("Rich") {
    val tid = "$baseTooltipId-rich"
    MDCRichTooltip(
      id = tid,
      interactive = interactive,
      persistent = persistent,
      anchorContent = {
        AnchorButton(tid)
      }
    ) {
      MDCTooltipTitle("Lorem Ipsum")
      MDCTooltipContent {
        Text(loremIpsum)
        MDCTooltipLink("link", "https://google.com")
      }
      MDCTooltipActions {
        MDCTooltipAction("action")
      }
    }
  }
}
