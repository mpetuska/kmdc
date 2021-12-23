package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.radio.MDCRadio
import local.sandbox.Sample
import local.sandbox.Samples

@Suppress("unused")
val RadioSamples = Samples("Radio") {
  val radioOptions = listOf("A", "B", "C")
  var selectedOption by remember { mutableStateOf(radioOptions[0]) }
  Sample("Default") {
    MDCFormField {
      radioOptions.forEach { text ->
        MDCRadio(
          checked = (text == selectedOption),
          opts = { label = text },
          attrs = {
            onInput { selectedOption = text }
          }
        )
      }
    }
  }
  Sample("Disabled") {
    MDCFormField {
      radioOptions.forEach { text ->
        MDCRadio(
          checked = (text == selectedOption),
          opts = {
            label = text
            disabled = true
          },
          attrs = {
            onInput { selectedOption = text }
          }
        )
      }
    }
  }
}
