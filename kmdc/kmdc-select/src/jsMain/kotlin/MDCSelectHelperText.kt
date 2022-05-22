package dev.petuska.kmdc.select

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*

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
