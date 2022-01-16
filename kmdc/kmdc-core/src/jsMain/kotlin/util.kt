package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectScope
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.Element
import org.w3c.dom.events.Event

public typealias Builder<T> = T.() -> Unit
public typealias ComposableBuilder<T> = @Composable Builder<T>

public external interface Destroyable {
  public fun destroy()
}

public abstract external class MDCEvent<T> : Event {
  public var detail: T
}

@MDCInternalDsl
public var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@MDCInternalDsl
public fun <T> Element.mdc(action: Builder<T>? = null): T? = mdc.unsafeCast<T?>()?.also { action?.invoke(it) }

@MDCInternalDsl
public inline fun <T : Any> jsObject(builder: Builder<T> = { }): T =
  js("({})").unsafeCast<T>().apply(builder)

@MDCInternalDsl
public fun <E : Element, T> AttrsBuilder<E>.initialiseMDC(
  mdcInit: (E) -> T,
  onDispose: Builder<T>? = null,
  postInit: (DisposableEffectScope.(el: E, mdc: T) -> Unit)? = null,
) {
  ref {
    it.mdc = mdcInit(it).also { mdc ->
      postInit?.invoke(this, it, mdc)
    }
    onDispose {
      it.mdc(onDispose)
    }
  }
}

@MDCInternalDsl
public fun <E : Element, T : Destroyable> AttrsBuilder<E>.initialiseMDC(
  mdcInit: (E) -> T,
  postInit: (DisposableEffectScope.(el: E, mdc: T) -> Unit)? = null,
) {
  initialiseMDC(mdcInit, Destroyable::destroy, postInit)
}

private var nextDomElementId = 0

/**
 * Returns a new unique DOM element ID.
 *
 * Guarantees 2^53-1 sequential IDs, good for 28 million IDs per second over a period of ten years.
 */
@MDCInternalDsl
public fun uniqueDomElementId(): String = "kmdc-${nextDomElementId++}"

@Composable
@MDCInternalDsl
@Suppress("NOTHING_TO_INLINE")
public inline fun rememberUniqueDomElementId(suffix: String? = null): String =
  remember { uniqueDomElementId() + (suffix?.let { "-$it" } ?: "") }
