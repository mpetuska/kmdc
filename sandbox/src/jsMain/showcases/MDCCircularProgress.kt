package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.circular.progress.*
import sandbox.control.*
import sandbox.util.*

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
  requireModule("./MDCCircularProgress.scss")
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
