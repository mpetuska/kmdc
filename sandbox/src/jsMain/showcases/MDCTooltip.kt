package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.katalog.runtime.util.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.tooltip.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*
import sandbox.util.*

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
    BooleanControl("Interactive", ::interactive)
    BooleanControl("Persistent", ::persistent)
  },
) {
  NamedBlock("Simple") {
    val tid = "$baseTooltipId-simple"
    AnchorButton(tid, "Hover over me")
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
        AnchorButton(tid, if (persistent) "Click me" else "Hover over me")
      }
    ) {
      MDCTooltipTitle("Lorem Ipsum")
      MDCTooltipContent {
        Text(loremIpsum)
        MDCTooltipLink("link", rickRollUrl, attrs = {
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
