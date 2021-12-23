package local.sandbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icons.MDCIcon
import dev.petuska.kmdc.icons.MDCIconOpts
import dev.petuska.kmdc.layout.grid.MDCLayoutGrid
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.typography.MDCH1
import dev.petuska.kmdc.typography.MDCH5
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    MDCH1("KMDC Sandbox") { style { textAlign("center") } }
    MDCLayoutGrid {
      MDCLayoutGridCells {
        samples.forEach { sample ->
          with(sample) { invoke() }
        }
      }
    }
  }
}

@Composable
private fun MDCLayoutGridCellsScope.NamedCell(name: String?, span: UInt = 6u, content: SampleRender) {
  var collapsed by remember { mutableStateOf(name != null) }
  MDCLayoutGridCell({ this.span = span }, attrs = {
    style {
      border(1.px, LineStyle.Solid, Color.gray)
      property("box-shadow", "6px 4px 8px grey")
    }
  }) {
    name?.let {
      MDCLayoutGrid {
        MDCLayoutGridCells {
          MDCLayoutGridCell({ this.span = 12u }, {
            style {
              display(DisplayStyle.Flex)
              flexDirection(FlexDirection.Row)
              justifyContent(JustifyContent.SpaceBetween)
              alignItems(AlignItems.Center)
            }
          }) {
            MDCH5(name, attrs = {
              style {
                margin(0.px)
              }
            })
            MDCIconButton(attrs = { onClick { collapsed = !collapsed } }) {
              MDCIcon({
                icon = if (collapsed) MDCIconOpts.MDCIconType.ArrowDropDown else MDCIconOpts.MDCIconType.ArrowDropUp
              })
            }
          }
        }
      }
      Hr {
        if (collapsed) hidden()
        style {
          border(1.25.px, LineStyle.Solid, Color.gray)
          borderRadius(5.px)
          margin(0.em, 1.em)
        }
      }
    }
    MDCLayoutGrid(attrs = {
      if (collapsed) hidden()
    }) {
      MDCLayoutGridCells {
        content()
      }
    }
  }
}

private val samples = mutableSetOf<Samples>()

typealias SampleRender = @Composable MDCLayoutGridCellsScope.() -> Unit

@DslMarker
annotation class SampleDsl

@SampleDsl
data class Samples(val name: String, private val content: SampleRender) {
  init {
    samples.add(this)
  }

  @SampleDsl
  @Composable
  operator fun MDCLayoutGridCellsScope.invoke() {
    NamedCell(name) {
      content()
    }
  }
}

@SampleDsl
@Composable
fun MDCLayoutGridCellsScope.Sample(
  name: String,
  content: @Composable MDCLayoutGridScope.(name: String) -> Unit
) {
  NamedCell(name) {
    MDCLayoutGridCell({ span = 12u }) {
      content(name)
    }
  }
}

@SampleDsl
@Composable
fun MDCLayoutGridCellsScope.Sample(
  span: UInt = 6u,
  content: @Composable MDCLayoutGridScope.() -> Unit
) {
  NamedCell(null, span) {
    MDCLayoutGridCell({ this.span = 12u }) {
      content()
    }
  }
}
