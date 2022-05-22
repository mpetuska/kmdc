package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
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
import sandbox.control.RangeControl

private class MDCElevationVM {
  var z by mutableStateOf(12)
}

@Composable
@Showcase(id = "MDCElevation")
fun MDCElevation() = InteractiveShowcase(
  viewModel = { MDCElevationVM() },
  controls = {
    RangeControl("Z", ::z, max = 24, converter = Number::toInt)
  },
) {
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
