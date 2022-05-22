package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.chips.MDCChipDisabledLocal
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.chips.action.Ripple
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Button
import org.w3c.dom.HTMLButtonElement

@MDCDsl
@Composable
internal fun GridAction(
  attrs: AttrsBuilder<HTMLButtonElement>?,
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
  }, content = {
    unsafeCast<MDCChipActionScope<HTMLButtonElement>>().Ripple()
    applyContent(content)
  })
}
