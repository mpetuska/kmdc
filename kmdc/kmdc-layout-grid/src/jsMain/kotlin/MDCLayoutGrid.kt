package dev.petuska.kmdc.layout.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/layout-grid/dist/mdc.layout-grid.css")
private external val MDCLayoutGridCSS: dynamic

public data class MDCLayoutGridOpts(
  var columnWidth: ColumnWidth = ColumnWidth.Default,
  var align: Align = Align.Center,
) {
  public enum class ColumnWidth(public vararg val classes: String) {
    Default,
    Fixed("mdc-layout-grid--fixed-column-width")
  }

  public enum class Align(public vararg val classes: String) {
    Center,
    Left("mdc-layout-grid--align-left"),
    Right("mdc-layout-grid--align-right"),
  }
}

public open class MDCLayoutGridScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope
public class MDCLayoutGridCellsScope(scope: ElementScope<HTMLDivElement>) : MDCLayoutGridScope(scope)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCDsl
@Composable
public fun MDCLayoutGrid(
  opts: MDCAttrs<MDCLayoutGridOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridScope>? = null
) {
  MDCLayoutGridCSS
  val options = MDCLayoutGridOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-layout-grid")
      classes(options.align.classes)
      classes(options.columnWidth.classes)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCLayoutGridScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCDsl
@Composable
public fun MDCLayoutGridScope.MDCLayoutGridCells(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridCellsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-layout-grid__inner")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCLayoutGridCellsScope(this).it() } }
  )
}
