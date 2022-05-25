package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.floating.label.MDCFloatingLabel
import sandbox.control.BooleanControl
import sandbox.control.TextControl

private class MDCFloatingLabelVM {
  var float by mutableStateOf(false)
  var required by mutableStateOf(false)
  var shake by mutableStateOf(false)
  var label by mutableStateOf("My Label")
}

@Composable
@Showcase(id = "MDCFloatingLabel")
fun MDCFloatingLabel() = InteractiveShowcase(
  viewModel = { MDCFloatingLabelVM() },
  controls = {
    BooleanControl("Float", ::float)
    BooleanControl("Required", ::required)
    BooleanControl("Shake", ::shake)
    TextControl("Label", label) { label = it }
  },
) {
  MDCFloatingLabel(
    id = "kmdc-showcase-floating-label",
    text = label,
    float = float,
    required = required,
    shake = shake,
  )
}
