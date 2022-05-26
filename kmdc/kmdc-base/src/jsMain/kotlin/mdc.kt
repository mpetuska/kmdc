package dev.petuska.kmdc.core

import org.w3c.dom.Element

@KMDCInternalAPI
@Deprecated(message = "To be removed")
internal var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@KMDCInternalAPI
@Deprecated(message = "To be removed")
public fun <MDC : MDCComponent<*>> Element.mdc(action: MDCAttrs<MDC>? = null): MDC? =
  mdc.unsafeCast<MDC?>()?.also { action?.invoke(it) }
