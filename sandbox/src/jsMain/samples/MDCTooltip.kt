package samples

import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.tooltip.MDCRichTooltip
import dev.petuska.kmdc.tooltip.MDCTooltip
import dev.petuska.kmdc.tooltip.MDCTooltipAction
import dev.petuska.kmdc.tooltip.MDCTooltipActions
import dev.petuska.kmdc.tooltip.MDCTooltipContent
import dev.petuska.kmdc.tooltip.MDCTooltipLink
import dev.petuska.kmdc.tooltip.MDCTooltipTitle
import dev.petuska.kmdc.tooltip.tooltipId
import org.jetbrains.compose.web.dom.Text

object MDCTooltip : Samples() {
  override val content: SamplesRender = {
    Simple()
    Rich()
    Interactive()
    Persistent()
  }

  private val Simple = Sample("Simple") {
    val tid = "tooltip-id"
    MDCButton(
      text = "Hover over me",
      attrs = {
        tooltipId(tid)
      }
    )
    MDCTooltip(
      id = tid,
      text = "lorem ipsum dolor"
    )
  }

  private val Rich = Sample("Rich") {
    val tid = "tt0"

    MDCRichTooltip(
      id = tid,
      anchorContent = {
        MDCButton(
          text = "Hover over me",
          attrs = {
            tooltipId(tid)
          }
        )
      }
    ) {
      MDCTooltipContent(
        """
         Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur
         pretium vitae est et dapibus. Aenean sit amet felis eu lorem fermentum
         aliquam sit amet sit amet eros.
      """.trimIndent()
      )
    }
  }

  private val Interactive = Sample("Interactive") {
    val tid = "tt1"

    MDCRichTooltip(
      id = tid,
      opts = { interactive = true },
      anchorContent = {
        MDCButton(
          text = "Hover over me",
          attrs = {
            tooltipId(tid)
          }
        )
      }
    ) {
      MDCTooltipTitle("Lorem Ipsum")
      MDCTooltipContent {
        Text(
          """
         Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur
         pretium vitae est et dapibus. Aenean sit amet felis eu lorem fermentum
         aliquam sit amet sit amet eros.
        """.trimIndent()
        )
        MDCTooltipLink("link", "https://google.com")
      }
      MDCTooltipActions {
        MDCTooltipAction("action")
      }
    }
  }

  private val Persistent = Sample("Persistent", "Lose focus to dismiss.") {
    val tid = "tt2"

    MDCRichTooltip(
      id = tid,
      opts = { persistent = true },
      anchorContent = {
        MDCButton(
          text = "Click me",
          attrs = {
            tooltipId(tid)
          }
        )
      }
    ) {
      MDCTooltipContent {
        Text("I won't go away until I lose focus")
      }
    }
  }
}