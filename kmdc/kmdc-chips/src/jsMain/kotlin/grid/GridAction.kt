package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.chips.MDCChipDisabledLocal
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.chips.action.Ripple
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Button
import org.w3c.dom.HTMLButtonElement

@MDCContentDsl
@Composable
internal fun GridAction(
  attrs: MDCAttrsRaw<HTMLButtonElement>?,
  content: MDCContent<MDCChipActionScope<HTMLButtonElement>>?
) {
  val type = MDCChipActionTypeLocal.current
  val disabled = MDCChipDisabledLocal.current
  Button(attrs = {
    classes("mdc-evolution-chip__action", "mdc-evolution-chip__action--$type")
    type(ButtonType.Button)
    if (disabled) {
      disabled()
    }
    applyAttrs(attrs)
  }) {
    unsafeCast<MDCChipActionScope<HTMLButtonElement>>().Ripple()
    applyContent(content)
  }
}
