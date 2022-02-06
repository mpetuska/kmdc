@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.events.Event
import kotlin.reflect.KMutableProperty1

public typealias Builder<T> = T.() -> Unit
public typealias ComposableBuilder<T> = @Composable Builder<T>

@MDCInternalDsl
public abstract external class MDCEvent<T> : Event {
  public var detail: T
}

@MDCInternalDsl
private var Element.mdc: dynamic
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
public fun <E : Element, T : MDCBaseModule.MDCComponent<*>> AttrsBuilder<E>.initialiseMDC(
  mdcInit: (E) -> T,
  onDispose: Builder<T>? = null,
  postInit: (T.(el: E) -> Unit)? = null,
) {
  ref {
    it.mdc = mdcInit(it).also { mdc ->
      postInit?.invoke(mdc, it)
    }
    onDispose {
      it.mdc<T> {
        destroy()
        onDispose?.invoke(this)
      }
    }
  }
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
public inline fun rememberUniqueDomElementId(suffix: String? = null): String =
  remember { uniqueDomElementId() + (suffix?.let { "-$it" } ?: "") }

@Composable
@MDCInternalDsl
public inline fun <T> rememberMutableStateOf(initial: T): MutableState<T> = remember { mutableStateOf(initial) }

@Composable
@MDCInternalDsl
public fun <MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  vararg keys: Any?,
  effect: Builder<MDC>
) {
  keys.forEach { key ->
    DomSideEffect(key) {
      it.mdc(effect)
    }
  }
}

@Composable
@MDCInternalDsl
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  setter: MDC.(V) -> Unit
) {
  DomSideEffect(value) {
    it.mdc<MDC> {
      setter(value)
    }
  }
}

@Composable
@MDCInternalDsl
public inline fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
) {
  MDCSideEffect(value, property::set)
}
