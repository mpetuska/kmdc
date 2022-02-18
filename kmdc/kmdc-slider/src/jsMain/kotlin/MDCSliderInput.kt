package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.max
import org.jetbrains.compose.web.attributes.min
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.step
import org.jetbrains.compose.web.dom.Input

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
internal fun MDCSliderOpts.MDCSliderInput(
  value: Number,
  min: Number,
  max: Number,
  label: String?,
  rangeStart: Boolean?,
  attrs: Builder<InputAttrsScope<Number?>>? = null,
) {
  Input(
    type = InputType.Range,
    attrs = {
      classes("mdc-slider__input")
      when (rangeStart) {
        null -> name("volume")
        true -> name("rangeStart")
        false -> name("rangeEnd")
      }
      if (label != null) aria("label", label)
      min("$min")
      max("$max")
      step(step)
      attr("value", "$value")
      if (disabled) disabled()
      attrs?.invoke(this)
    }
  )
}
