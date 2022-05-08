package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonType

object MDCButton : Samples() {
  override val content: SamplesRender = {
    MDCButtonType.values().forEach {
      Sample("$it") { _ ->
        var count by remember { mutableStateOf(0) }
        MDCButton(text = "Clicked $count times", type = it, attrs = { onClick { count++ } })
      }
    }
  }
}
