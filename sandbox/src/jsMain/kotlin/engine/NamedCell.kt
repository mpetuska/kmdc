package engine

import androidx.compose.runtime.*
import dev.petuska.kmdc.icon.button.*
import dev.petuska.kmdc.layout.grid.*
import dev.petuska.kmdc.typography.*
import dev.petuska.kmdcx.icons.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*
import samples.*

@Composable
fun SamplesScope.NamedCell(
  name: String?,
  description: String? = null,
  span: UInt = 6u,
  sample: Boolean = false,
  titleRender: @Composable (text: String, attrs: AttrBuilderContext<HTMLHeadingElement>?) -> Unit = { text, attrs ->
    MDCH6(
      text,
      attrs
    )
  },
  content: @Composable SamplesScope.() -> Unit
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
      if (sample && name == null) classes("sample-container")
    }) {
      if (sample) {
        content()
      } else {
        MDCLayoutGridCells {
          content()
        }
      }
    }
  }
}
