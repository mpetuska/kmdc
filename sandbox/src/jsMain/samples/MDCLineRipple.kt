package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.line.ripple.MDCLineRipple
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.dom.Div
import sandbox.control.BooleanControl


private class MDCLineRippleVM {
  var active by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCLineRipple")
fun MDCLineRipple() = InteractiveShowcase(
  viewModel = { MDCLineRippleVM() },
  controls = {
    BooleanControl("Active", ::active)
  },
) {
  Div(attrs = {
    style {
      display(DisplayStyle.LegacyInlineFlex)
      position(Position.Relative)
    }
  }) {
    org.jetbrains.compose.web.dom.TextInput("Notice the thick line bellow", attrs = {
      disabled()
    })
    MDCLineRipple(active)
  }
}
