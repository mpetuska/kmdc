package dev.petuska.katalog.runtime.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.katalog.runtime.UtilStyle
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

public object InteractiveShowcaseStyle : StyleSheet() {
  public val container: String by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
  }
  public val content: String by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Row)
  }
  public val preview: String by style {
    width(100.percent)
  }
  public val stickyBox: String by style {
    position(Position.Sticky)
    top(0.em)
  }
  public val controls: String by style {
    property("width", "fit-content")
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    marginLeft(1.em)
  }
  public val controlsSpacer: String by style {
    minWidth(20.em)
  }
}

@Composable
public inline fun <VM : Any> InteractiveShowcase(
  viewModel: () -> VM,
  noinline controls: (@Composable VM.() -> Unit)? = null,
  noinline details: (@Composable () -> Unit)? = null,
  crossinline preview: @Composable VM.() -> Unit,
) {
  val vm = remember(viewModel)
  Style(InteractiveShowcaseStyle)
  Div(attrs = { classes(InteractiveShowcaseStyle.container) }) {
    H4 { Text("Playground") }
    Div(attrs = { classes(InteractiveShowcaseStyle.content) }) {
      Div(attrs = { classes(InteractiveShowcaseStyle.preview, UtilStyle.roundedBoxShadow) }) {
        Div(attrs = { classes(InteractiveShowcaseStyle.stickyBox) }) {
          vm.preview()
        }
      }
      if (controls != null) {
        Div(attrs = { classes(InteractiveShowcaseStyle.controls, UtilStyle.roundedBoxShadow) }) {
          Div(attrs = { classes(InteractiveShowcaseStyle.stickyBox) }) {
            Div(attrs = { classes(InteractiveShowcaseStyle.controlsSpacer) })
            vm.controls()
          }
        }
      }
    }
    if (details != null) {
      Div {
        H4 { Text("Details") }
        Div {
          details()
        }
      }
    }
  }
}
