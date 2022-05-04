package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.Span

@MDCDsl
@Composable
internal fun MDCChipActionScope<*>.Ripple() {
  val type = MDCChipActionTypeLocal.current
  Span(
    attrs = {
      classes("mdc-evolution-chip__ripple", "mdc-evolution-chip__ripple--$type")
    }
  )
}
