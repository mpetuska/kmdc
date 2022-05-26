package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

public interface MDCChipActionIconScope<T : HTMLElement> : MDCChipActionScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
public fun MDCChipActionIconScope<*>.Icon(
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null
) {
  val type = MDCChipActionTypeLocal.current
  I(
    attrs = {
      classes("mdc-evolution-chip__icon", "mdc-evolution-chip__icon--$type")
      if (type == "trailing") classes("mdc-chip-trailing-action")
      applyAttrs(attrs)
    },
    content = content
  )
}
