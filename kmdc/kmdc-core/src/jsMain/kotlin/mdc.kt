@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import org.w3c.dom.Element

@KMDCInternalAPI
internal var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> Element.mdc(action: MDCAttrs<MDC>? = null): MDC? =
  mdc.unsafeCast<MDC?>()?.also { action?.invoke(it) }
