@file:JsModule("@material/textfield")

package dev.petuska.kmdc.textfield

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.MDCLayoutComponent
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCTextField(element: Element) : MDCComponent<dynamic>, MDCLayoutComponent {
  public var value: String
  public var disabled: Boolean
  public var valid: Boolean
  public var prefixText: String
  public var suffixText: String

  // Proxied from input element
  public var required: Boolean
  public var pattern: String
  public var minLength: Number
  public var maxLength: Number
  public var min: Number
  public var max: Number
  public var step: Number

  // Write-only
  public var useNativeValidation: Boolean
  public var helperTextContent: String
  public var ripple: MDCRipple
  public var leadingIconAriaLabel: String
  public var trailingIconAriaLabel: String
  public var leadingIconContent: String
  public var trailingIconContent: String

  public fun focus()
  public override fun layout()
}
