package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.elevation.*
import dev.petuska.kmdc.typography.*
import org.jetbrains.compose.web.css.*
import sandbox.control.*

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
