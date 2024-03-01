package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.form.field.MDCFormFieldAlign
import dev.petuska.kmdc.radio.MDCRadio
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl

private class MDCFormFieldVM {
  var align by mutableStateOf(MDCFormFieldAlign.Start)
  var noWrap by mutableStateOf(false)

  var checked by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCFormField")
fun MDCFormField() = InteractiveShowcase(
  viewModel = { MDCFormFieldVM() },
  controls = {
    ChoiceControl("Align", MDCFormFieldAlign.values().associateBy(MDCFormFieldAlign::name), ::align)
    BooleanControl("No Wrap", ::noWrap)
  },
) {
  MDCFormField(
    align = align,
    noWrap = noWrap,
  ) {
    MDCCheckbox(
      checked = checked,
      label = "Sample Checkbox",
      attrs = { onInput { checked = !checked } },
    )
  }
  MDCFormField(
    align = align,
    noWrap = noWrap,
  ) {
    MDCRadio(
      checked = checked,
      label = "Sample Radio",
      attrs = { onInput { checked = !checked } },
    )
  }
}
