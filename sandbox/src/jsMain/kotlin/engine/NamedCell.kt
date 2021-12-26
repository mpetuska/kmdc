package local.sandbox.engine

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
import dev.petuska.kmdc.typography.MDCCaption
import dev.petuska.kmdc.typography.MDCH6
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
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.w3c.dom.HTMLHeadingElement

@Composable
fun MDCLayoutGridCellsScope.NamedCell(
  name: String?,
  description: String? = null,
  span: UInt = 6u,
  titleRender: @Composable (text: String, attrs: AttrBuilderContext<HTMLHeadingElement>?) -> Unit = { text, attrs ->
    MDCH6(
      text,
      attrs
    )
  },
  content: SampleRender
) {
  var collapsed by remember { mutableStateOf(false) }
  MDCLayoutGridCell({ this.span = span }, attrs = {
    style {
      border(1.px, LineStyle.Solid, Color.gray)
      borderRadius(1.em)
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
            Div(attrs = {
              style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
              }
            }) {
              titleRender(name) {
                style {
                  margin(0.px)
                }
              }
              description?.let {
                MDCCaption(description)
              }
            }
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
