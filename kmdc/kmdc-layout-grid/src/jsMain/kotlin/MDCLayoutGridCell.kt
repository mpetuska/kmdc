package dev.petuska.kmdc.layout.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

public data class MDCLayoutGridCellOpts(
  var span: UInt? = null,
  var spanMap: SpanMap? = null,
  var order: UInt? = null,
  var align: Align = Align.Stretch,
) {
  public data class SpanMap(val desktop: UInt, val tablet: UInt, val phone: UInt)
  public enum class Align(public vararg val classes: String) {
    Stretch,
    Top("mdc-layout-grid__cell--align-top"),
    Middle("mdc-layout-grid__cell--align-middle"),
    Bottom("mdc-layout-grid__cell--align-bottom")
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-layout-grid)
 */
@MDCDsl
@Composable
public fun MDCLayoutGridCellsScope.MDCLayoutGridCell(
  opts: Builder<MDCLayoutGridCellOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCLayoutGridScope>? = null
) {
  val options = MDCLayoutGridCellOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-layout-grid__cell", *options.align.classes)
      options.order?.let { classes("mdc-layout-grid__cell--order-$it") }
      options.span?.let { classes("mdc-layout-grid__cell--span-$it") }
      options.spanMap?.let {
        classes(
          "mdc-layout-grid__cell--span-${it.desktop}-desktop",
          "mdc-layout-grid__cell--span-${it.tablet}-tablet",
          "mdc-layout-grid__cell--span-${it.phone}-phone",
        )
      }
      attrs?.invoke(this)
    },
    content = content?.let { { MDCLayoutGridCellsScope(this).it() } }
  )
}
