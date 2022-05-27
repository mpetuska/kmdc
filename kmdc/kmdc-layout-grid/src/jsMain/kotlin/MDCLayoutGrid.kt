package dev.petuska.kmdc.layout.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/layout-grid/mdc-layout-grid.scss")
private external val Style: dynamic

public enum class MDCLayoutGridAlign(public vararg val classes: String) {
  Center,
  Left("mdc-layout-grid--align-left"),
  Right("mdc-layout-grid--align-right"),
}

public interface MDCLayoutGridScope : ElementScope<HTMLDivElement>
public interface MDCLayoutGridCellsScope : MDCLayoutGridScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCContentDsl
@Composable
public fun MDCLayoutGrid(
  align: MDCLayoutGridAlign = MDCLayoutGridAlign.Center,
  fixedColumnWidth: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridScope>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-layout-grid")
      classes(align.classes)
      if (fixedColumnWidth) classes("mdc-layout-grid--fixed-column-width")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCContentDsl
@Composable
public fun MDCLayoutGridScope.Cells(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridCellsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-layout-grid__inner")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}
