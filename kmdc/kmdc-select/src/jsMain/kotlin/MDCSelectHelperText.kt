package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
internal fun MDCSelectHelperText(id: String, text: String, type: MDCSelectOpts.HelperTextType) {
  P(
    attrs = {
      id(id)
      classes("mdc-select-helper-text")
      classes(type.classes)
    }
  ) {
    MDCInitEffect(MDCSelectModule::MDCSelectHelperText)
    Text(text)
  }
}
