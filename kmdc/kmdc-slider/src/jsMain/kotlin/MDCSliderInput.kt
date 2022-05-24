package dev.petuska.kmdc.slider

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.attributes.builders.*
import org.jetbrains.compose.web.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
internal fun MDCSliderInput(
  value: Number,
  min: Number,
  max: Number,
  label: String?,
  rangeStart: Boolean?,
  disabled: Boolean,
  step: Number,
  attrs: MDCAttrs<InputAttrsScope<Number?>>? = null,
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
