package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.linear.progress.MDCLinearProgress
import sandbox.control.BooleanControl
import sandbox.control.RangeControl
import sandbox.control.TextControl

private class MDCLinearProgressVM {
  var progress by mutableStateOf(0.5)
  var buffer by mutableStateOf(0.5)
  var determinate by mutableStateOf(false)
  var closed by mutableStateOf(false)
  var label by mutableStateOf("My Label")
}

@Composable
@Showcase(id = "MDCLinearProgress")
fun MDCLinearProgress() = InteractiveShowcase(
  viewModel = { MDCLinearProgressVM() },
  controls = {
    BooleanControl("Determinate", ::determinate)
    BooleanControl("Closed", ::closed)
    TextControl("Label", ::label)
    RangeControl(
      name = "Progress",
      value = ::progress,
      max = 1,
      step = 0.05,
      converter = Number::toDouble
    )
    RangeControl(
      name = "Buffer",
      value = ::buffer,
      min = progress,
      max = 1,
      step = 0.05,
      converter = Number::toDouble
    )
  },
) {
  MDCLinearProgress(
    progress = progress,
    buffer = buffer,
    determinate = determinate,
    closed = closed,
    label = label.takeIf(String::isNotBlank),
  )
}
