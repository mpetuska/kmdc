package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCChipActionIconScope<T : HTMLElement> : MDCChipActionScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipActionIconScope<*>.Icon(
  attrs: AttrsBuilder<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null
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
