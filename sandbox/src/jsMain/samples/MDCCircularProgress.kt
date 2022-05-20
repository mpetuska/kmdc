package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.circular.progress.MDCCircularProgress
import sandbox.control.BooleanControl
import sandbox.control.RangeControl
import sandbox.control.TextControl

private class MDCCircularProgressVM {
  var determinate by mutableStateOf(false)
  var closed by mutableStateOf(false)
  var fourColor by mutableStateOf(false)
  var label by mutableStateOf("My Label")
  var size by mutableStateOf(36)
  var progress by mutableStateOf(0.5)
}

@Composable
@Showcase(id = "MDCCircularProgress")
fun MDCCircularProgress() = InteractiveShowcase(
  viewModel = { MDCCircularProgressVM() },
  controls = {
    BooleanControl("Determinate", ::determinate)
    BooleanControl("Closed", ::closed)
    BooleanControl("Four Color", ::fourColor)
    TextControl("Label", ::label)
    RangeControl(
      name = "Size",
      value = ::size,
      min = 24,
      max = 48,
      converter = Number::toInt
    )
    RangeControl(
      name = "Progress",
      value = ::progress,
      max = 1,
      step = 0.05,
      converter = Number::toDouble
    )
  },
) {
  require("./MDCCircularProgress.scss")
  MDCCircularProgress(
    determinate = determinate,
    closed = closed,
    label = label.takeIf(String::isNotBlank),
    progress = progress,
    size = size,
    fourColor = fourColor,
    attrs = {
      classes("kmdc-circular-progress")
    }
  )
}
