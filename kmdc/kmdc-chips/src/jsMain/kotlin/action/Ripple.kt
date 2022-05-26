package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*

@MDCContentDsl
@Composable
internal fun MDCChipActionScope<*>.Ripple() {
  val type = MDCChipActionTypeLocal.current
  Span(
    attrs = {
      classes("mdc-evolution-chip__ripple", "mdc-evolution-chip__ripple--$type")
    }
  )
}
