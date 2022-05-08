package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.events.Event

public external class MDCEvent<T> internal constructor() : Event {
  public val detail: T
}

public typealias MDCEventHandler<A, D> = A.(listener: (MDCEvent<D>) -> Unit) -> Unit

@KMDCInternalAPI
@Suppress("FunctionName")
public fun <A : AttrsScope<*>, D> MDCEvent(
  eventName: String
): MDCEventHandler<A, D> {
  return { listener ->
    addEventListener(eventName) {
      listener(it.nativeEvent.unsafeCast<MDCEvent<D>>())
    }
  }
}
