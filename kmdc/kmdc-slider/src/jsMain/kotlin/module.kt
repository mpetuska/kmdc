@file:JsModule("@material/slider")

package dev.petuska.kmdc.slider

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCSlider(
  element: Element,
  options: MDCSliderOptions = definedExternally
) : MDCBaseModule.MDCComponent<dynamic> {
  public var root: HTMLElement
  public fun initialize(options: MDCSliderOptions = definedExternally): dynamic
  public fun layout()
  public fun getValueStart(): Number
  public fun setValueStart(valueStart: Number)
  public fun getValue(): Number
  public fun setValue(value: Number)
  public fun getDisabled(): Boolean
  public fun setDisabled(disabled: Boolean)
  public fun setValueToAriaValueTextFn(mapFn: ((value: Number) -> String)?)
}

@MDCExternalAPI
public external interface MDCSliderOptions {
  public var skipInitialUIUpdate: Boolean?
}
