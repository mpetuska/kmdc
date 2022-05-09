package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.line.ripple.MDCLineRipple
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

object MDCLineRipple : Samples() {
  override val content: SamplesRender = {
    Sample {
      var active by rememberMutableStateOf(false)
      Div {
        MDCFormField {
          MDCCheckbox(
            active,
            label = "Active",
            attrs = {
              onInput { active = !active }
            }
          )
        }
      }
      Hr()
      Div {
        MDCLineRipple(active)
      }
    }
  }
}
