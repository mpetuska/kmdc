package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.floating.label.MDCFloatingLabel
import dev.petuska.kmdc.notched.outline.Leading
import dev.petuska.kmdc.notched.outline.MDCNotchedOutline
import dev.petuska.kmdc.notched.outline.Notch
import dev.petuska.kmdc.notched.outline.Trailing
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import sandbox.control.BooleanControl
import sandbox.control.TextControl

private class MDCNotchedOutlineVM {
  var notched by mutableStateOf(false)
  var noLabel by mutableStateOf(false)
  var label by mutableStateOf("My Label")
}

@Composable
@Showcase(id = "MDCNotchedOutline")
fun MDCNotchedOutline() = InteractiveShowcase(
  viewModel = { MDCNotchedOutlineVM() },
  controls = {
    BooleanControl("Notched", ::notched)
    BooleanControl("No Label", ::noLabel)
    TextControl("Label", ::label)
  },
) {
  Div(attrs = {
    style {
      height(43.px)
    }
  }) {
    MDCNotchedOutline(
      noLabel = noLabel,
      notched = notched,
      attrs = {
        style {
          width(200.px)
        }
      }
    ) {
      Leading()
      Notch {
        MDCFloatingLabel(
          text = label,
          float = notched,
          id = "kmdc-notched-outline-label",
          attrs = {
            style {
              marginTop(0.75.em)
              paddingLeft(0.5.em)
            }
          }
        )
      }
      Trailing()
    }
  }
}
