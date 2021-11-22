package local.sandbox.sample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.textfield.MDCTextField
import local.sandbox.Samples
import local.sandbox.Samples.Sample

val TextFieldSamples = Samples {
  Sample {
    var text by remember { mutableStateOf("") }
    MDCTextField(
      opts = { label = "Sample TextField" },
      attrs = {
        value(text)
        onInput { text = it.value }
      }
    )
  }
}
