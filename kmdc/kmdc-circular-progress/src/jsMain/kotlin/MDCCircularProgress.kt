package dev.petuska.kmdc.circular.progress

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.svg.Circle
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLDivElement

@JsModule("@material/circular-progress/mdc-circular-progress.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-circular-progress)
 */
@MDCContentDsl
@Composable
public fun MDCCircularProgress(
  progress: Double = 0.0,
  determinate: Boolean = false,
  closed: Boolean = false,
  label: String? = null,
  size: Int = 48,
  fourColor: Boolean = false,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
) {
  Style
  Div(attrs = {
    classes("mdc-circular-progress")
    role("progressbar")
    aria("valuemin", 0)
    aria("valuemax", 1)
    aria("valuenow", progress)
    label?.let { aria("label", it) }
    if (!determinate) classes("mdc-circular-progress--indeterminate")
    if (closed) classes("mdc-circular-progress--closed")
    style {
      width(size.px)
      height(size.px)
    }
    applyAttrs(attrs)
  }) {
    MDCProvider(::MDCCircularProgress, size, fourColor) {
      MDCStateEffectNew(determinate, MDCCircularProgress::determinate)
      MDCStateEffectNew(progress.coerceIn(0.0, 1.0), MDCCircularProgress::progress)

      MDCCircularProgressDeterminateContainer(size)
      MDCCircularProgressIndeterminateContainer(size, fourColor)
    }
  }
}

@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCContentDsl
@Composable
private fun MDCCircularProgressDeterminateContainer(size: Int) {
  val cSize = size / 2
  val rSize = size / 2.666666667
  val daSize = size * 2.3561875
  val sSize = size / 12.0
  Div({ classes("mdc-circular-progress__determinate-container") }) {
    Svg(
      viewBox = "0 0 $size $size",
      attrs = { classes("mdc-circular-progress__determinate-circle-graphic") }
    ) {
      Circle(cx = cSize, cy = cSize, r = rSize, attrs = {
        classes("mdc-circular-progress__determinate-track")
        attr("stroke-width", "$sSize")
      })
      Circle(cx = cSize, cy = cSize, r = rSize, attrs = {
        classes("mdc-circular-progress__determinate-circle")
        attr("stroke-dasharray", "$daSize")
        attr("stroke-dashoffset", "$daSize")
        attr("stroke-width", "$sSize")
      })
    }
  }
}

@MDCContentDsl
@Composable
private fun MDCCircularProgressIndeterminateContainer(size: Int, fourColor: Boolean) {
  Div(attrs = { classes("mdc-circular-progress__indeterminate-container") }) {
    if (fourColor) {
      repeat(4) {
        MDCCircularProgressSpinnerLayer(size, it + 1)
      }
    } else {
      MDCCircularProgressSpinnerLayer(size, null)
    }
  }
}

@MDCContentDsl
@Composable
private fun MDCCircularProgressSpinnerLayer(size: Int, color: Int?) {
  val sSize1 = size / 12.0
  val sSize2 = size / 15.0
  Div({
    classes("mdc-circular-progress__spinner-layer")
    color?.let { classes("mdc-circular-progress__color-$color") }
  }) {
    Div({ classes("mdc-circular-progress__circle-clipper", "mdc-circular-progress__circle-left") }) {
      MDCCircularProgressIndeterminateGraphic(size, sSize1)
    }
    Div({ classes("mdc-circular-progress__gap-patch") }) {
      MDCCircularProgressIndeterminateGraphic(size, sSize2)
    }
    Div({ classes("mdc-circular-progress__circle-clipper", "mdc-circular-progress__circle-right") }) {
      MDCCircularProgressIndeterminateGraphic(size, sSize1)
    }
  }
}

@MDCContentDsl
@Composable
@OptIn(ExperimentalComposeWebSvgApi::class)
private fun MDCCircularProgressIndeterminateGraphic(size: Int, sSize: Number) {
  val cSize = size / 2.0
  val rSize = size / 2.666666667
  val daSize = size * 2.3561875
  val doSize = size * 1.178104167
  Svg(
    viewBox = "0 0 $size $size",
    attrs = { classes("mdc-circular-progress__indeterminate-circle-graphic") }
  ) {
    Circle(cx = cSize, cy = cSize, r = rSize, attrs = {
      attr("stroke-dasharray", "$daSize")
      attr("stroke-dashoffset", "$doSize")
      attr("stroke-width", "$sSize")
    })
  }
}
