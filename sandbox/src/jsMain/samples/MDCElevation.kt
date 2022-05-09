package samples

import dev.petuska.kmdc.elevation.MDCElevation
import dev.petuska.kmdc.typography.MDCBody1
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width

object MDCElevation : Samples() {
  override val content: SamplesRender = {
    repeat(25) { z ->
      Sample(span = 2u) {
        MDCElevation(z = z, attrs = {
          style {
            width(200.px)
            height(100.px)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
          }
        }) {
          MDCBody1("z: ${z}dp")
        }
      }
    }
  }
}
