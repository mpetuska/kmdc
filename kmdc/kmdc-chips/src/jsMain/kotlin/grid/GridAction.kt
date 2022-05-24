package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.chips.action.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.AttrsBuilder
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
