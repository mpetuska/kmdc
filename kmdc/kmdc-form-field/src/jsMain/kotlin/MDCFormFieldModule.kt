package dev.petuska.kmdc.form.field

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/form-field")
public external object MDCFormFieldModule {
  public class MDCFormField(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var input: MDCFormFieldInput
  }

  public interface MDCFormFieldInput {
    public val ripple: MDCRippleModule.MDCRipple?
  }
}
