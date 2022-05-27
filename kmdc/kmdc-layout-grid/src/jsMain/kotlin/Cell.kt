package dev.petuska.kmdc.layout.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

public data class SpanMap(val desktop: UInt, val tablet: UInt, val phone: UInt)

public enum class MDCLayoutGridCellAlign(public vararg val classes: String) {
  Stretch,
  Top("mdc-layout-grid__cell--align-top"),
  Middle("mdc-layout-grid__cell--align-middle"),
  Bottom("mdc-layout-grid__cell--align-bottom")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-layout-grid)
 */
@MDCContentDsl
@Composable
public fun MDCLayoutGridCellsScope.Cell(
  span: UInt? = null,
  spanMap: SpanMap? = null,
  order: UInt? = null,
  align: MDCLayoutGridCellAlign = MDCLayoutGridCellAlign.Stretch,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCLayoutGridScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-layout-grid__cell")
      classes(align.classes)
      order?.let { classes("mdc-layout-grid__cell--order-$it") }
      span?.let { classes("mdc-layout-grid__cell--span-$it") }
      spanMap?.let {
        classes(
          "mdc-layout-grid__cell--span-${it.desktop}-desktop",
          "mdc-layout-grid__cell--span-${it.tablet}-tablet",
          "mdc-layout-grid__cell--span-${it.phone}-phone",
        )
      }
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}
