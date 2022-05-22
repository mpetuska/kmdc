package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.events.Event

public external class MDCEvent<T> internal constructor() : Event {
  public val detail: T
}

public typealias MDCEventListener<D> = @MDCAttrsDsl (event: MDCEvent<D>) -> Unit

@KMDCInternalAPI
@Suppress("FunctionName")
public fun <A : AttrsScope<*>, D> A.addMdcEventListener(
  eventName: String,
  listener: MDCEventListener<D>
) {
  addEventListener(eventName) {
    listener(it.nativeEvent.unsafeCast<MDCEvent<D>>())
  }
}
