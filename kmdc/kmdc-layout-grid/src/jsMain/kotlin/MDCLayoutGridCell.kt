package dev.petuska.kmdc.layout.grid

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCContentDsl
@Composable
public fun MDCLayoutGridCellsScope.MDCLayoutGridCell(
  opts: MDCAttrs<MDCLayoutGridCellOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridScope>? = null
) {
  val options = MDCLayoutGridCellOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-layout-grid__cell")
      classes(options.align.classes)
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
