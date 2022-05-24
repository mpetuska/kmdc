@file:JsModule("@material/select")

package dev.petuska.kmdc.select

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCSelect(element: Element) : MDCComponent<dynamic> {
  public var value: String
  public var selectedIndex: String
  public var disabled: Boolean
  public var leadingIconAriaLabel: String
  public var helperTextContent: String
  public var useDefaultValidation: Boolean
  public var valid: Boolean
  public var required: Boolean

  public fun layout()
  public fun layoutOptions()
  public fun setValue(value: String, skipNotify: Boolean = definedExternally)
  public fun setSelectedIndex(selectedIndex: Int, skipNotify: Boolean = definedExternally)
}

@MDCExternalAPI
public external class MDCSelectHelperText(element: Element) : MDCComponent<dynamic>

@MDCExternalAPI
public external class MDCSelectIcon(element: Element) : MDCComponent<dynamic>
