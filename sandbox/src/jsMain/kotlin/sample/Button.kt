package local.sandbox.sample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonOpts
import local.sandbox.Samples
import local.sandbox.Samples.Sample

@Suppress("unused")
val ButtonSamples = Samples("Button") {
  Sample("Raised") {
    var count by remember { mutableStateOf(0) }
    MDCButton(
      text = "Clicked $count times",
      opts = { type = MDCButtonOpts.Type.Raised },
      attrs = { onClick { count++ } }
    )
  }
}
