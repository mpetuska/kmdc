package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.LoremIpsum
import dev.petuska.katalog.runtime.util.RickRollUrl
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonType
import dev.petuska.kmdc.tooltip.*
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.util.NamedBlock

private class MDCTooltipVM {
  var interactive by mutableStateOf(false)
  var persistent by mutableStateOf(false)
  val baseTooltipId = "kmdc-tooltip-id-"
}

@Composable
@Showcase(id = "MDCTooltip")
fun MDCTooltip() = InteractiveShowcase(
  viewModel = { MDCTooltipVM() },
  controls = {
    BooleanControl("Persistent", ::persistent)
    BooleanControl("Interactive", ::interactive)
  },
) {
  NamedBlock("Simple") {
    val tid = "$baseTooltipId-simple"
    AnchorButton(tid, "Hover over me")
    MDCTooltip(
      id = tid,
      persistent = persistent,
      text = LoremIpsum
    )
  }
  NamedBlock("Rich") {
    val tid = "$baseTooltipId-rich"
    MDCRichTooltip(
      id = tid,
      interactive = interactive,
      persistent = persistent,
      anchorContent = {
        AnchorButton(tid, if (persistent) "Click me" else "Hover over me")
      }
    ) {
      Title("Lorem Ipsum")
      Content {
        Text(LoremIpsum)
        Link("link", RickRollUrl, attrs = {
          target(ATarget.Blank)
        })
      }
      MDCTooltipActions {
        MDCTooltipAction("action")
      }
    }
  }
}

@Composable
private fun AnchorButton(tid: String, text: String) {
  MDCButton(
    text = text,
    type = MDCButtonType.Raised,
    attrs = {
      tooltipId(tid)
    }
  )
}
