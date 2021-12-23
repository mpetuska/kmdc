package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import local.sandbox.Sample
import local.sandbox.Samples

@Suppress("unused")
val TextFieldSamples = Samples("TextField") {
  MDCTextFieldCommonOpts.Type.values().forEach { t ->
    Sample("$t") { name ->
      var text by remember { mutableStateOf("") }
      MDCTextField(
        text,
        opts = {
          type = t
          label = "$name TextField"
        },
        attrs = {
          onInput { text = it.value }
        }
      )
    }
  }
}
