package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonOpts
import local.sandbox.Sample
import local.sandbox.Samples

@Suppress("unused")
val ButtonSamples = Samples("Button") {
  MDCButtonOpts.Type.values().forEach {
    Sample("$it") { _ ->
      var count by remember { mutableStateOf(0) }
      MDCButton(
        text = "Clicked $count times",
        opts = { type = it },
        attrs = { onClick { count++ } }
      )
    }
  }
}
