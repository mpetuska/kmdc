package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
internal fun MDCSelectHelperText(helperTextId: String, helperText: MDCSelectHelperText) {
  P(
    attrs = {
      id(helperTextId)
      classes(*helperText.type.classes)
      initialiseMDC(MDCSelectModule.MDCSelectHelperText.Companion::attachTo)
    }
  ) {
    Text(helperText.text)
  }
}
