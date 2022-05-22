package dev.petuska.kmdc.form.field

import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/form-field")
public external object MDCFormFieldModule {
  public class MDCFormField(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var input: MDCFormFieldInput
  }

  public interface MDCFormFieldInput {
    public val ripple: MDCRipple?
  }
}
