package dev.petuska.katalog.runtime.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.katalog.runtime.UtilStyle
import org.jetbrains.compose.web.css.*
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
  public val prominent: String by style {
    property("z-index", "1")
  }
  public val stickyBox: String by style {
    position(Position.Sticky)
    top(1.em)
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
  crossinline viewModel: () -> VM,
  prominent: Boolean = true,
  noinline controls: (@Composable VM.() -> Unit)? = null,
  noinline details: (@Composable () -> Unit)? = null,
  crossinline preview: @Composable VM.() -> Unit,
) {
  val vm = remember(viewModel)
  Style(InteractiveShowcaseStyle)
  Div(attrs = { classes(InteractiveShowcaseStyle.container) }) {
    H4 { Text("Playground") }
    Div(attrs = { classes(InteractiveShowcaseStyle.content) }) {
      Div(attrs = {
        classes(InteractiveShowcaseStyle.preview, UtilStyle.roundedBoxShadow)
        if (prominent) classes(InteractiveShowcaseStyle.prominent)
      }) {
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
