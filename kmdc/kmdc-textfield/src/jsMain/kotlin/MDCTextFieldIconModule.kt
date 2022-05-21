package dev.petuska.kmdc.textfield

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/textfield/icon")
public external object MDCTextFieldIconModule {
  public class MDCTextFieldIcon(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public val foundationForTextField: dynamic
  }
}
