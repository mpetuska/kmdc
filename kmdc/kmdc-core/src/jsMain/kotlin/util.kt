@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.events.Event
import kotlin.reflect.KMutableProperty1

public typealias Builder<T> = T.() -> Unit
public typealias AttrsBuilder<T> = org.jetbrains.compose.web.dom.AttrBuilderContext<T>
public typealias ComposableBuilder<T> = @Composable Builder<T>
public typealias ContentBuilder<T> = org.jetbrains.compose.web.dom.ContentBuilder<T>

/**
 * Implies [ComposableBuilder] lambda as a parent [ContentBuilder] lambda, converting implicit [ElementScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver lambda to rescope
 * @return rescoped lambda that implies [T] on invocation
 */
@KMDCInternalAPI
public inline fun <E : Element, T : ElementScope<E>> ComposableBuilder<T>.imply(): ContentBuilder<E> {
  return let { { unsafeCast<T>().it() } }
}

/**
 * Applies [Builder]<[T]> to [AttrsBuilder]<[E]>, converting implicit [AttrsScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 */
@KMDCInternalAPI
public inline fun <E : Element, T : AttrsScope<E>> AttrsScope<E>.applyAttrs(noinline block: Builder<T>?) {
  block?.invoke(unsafeCast<T>())
}

/**
 * Applies [ComposableBuilder]<[T]> to [ContentBuilder]<[E]>, converting implicit [ElementScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 */
@Composable
@KMDCInternalAPI
public inline fun <E : Element, T : ElementScope<E>> ElementScope<E>.applyContent(noinline block: ComposableBuilder<T>?) {
  block?.invoke(unsafeCast<T>())
}

@KMDCInternalAPI
public inline fun <T : Element, E : ElementScope<T>> ComposableBuilder<E>?.reinterpret(): ContentBuilder<T>? =
  this?.let { { unsafeCast<E>().it() } }

@KMDCInternalAPI
public abstract external class MDCEvent<T> : Event {
  public var detail: T
}

@KMDCInternalAPI
private var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@KMDCInternalAPI
public fun <T> Element.mdc(action: Builder<T>? = null): T? = mdc.unsafeCast<T?>()?.also { action?.invoke(it) }

@KMDCInternalAPI
public inline fun <T : Any> jsObject(builder: Builder<T> = { }): T =
  js("({})").unsafeCast<T>().apply(builder)

@KMDCInternalAPI
public fun <E : Element, T : MDCBaseModule.MDCComponent<*>> AttrsScope<E>.initialiseMDC(
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

/**
 * We're hooking it up to global context to avoid duplicate counters
 * in case multiple kmdc versions somehow make it into the same project
 */
private val nextDomElementId: Int
  get() {
    val key = "_kmdcCounter" // NEVER EVER CHANGE THIS
    val dynamicWindow = window.asDynamic()
    val next = (dynamicWindow[key] ?: 0) + 1
    dynamicWindow[key] = next
    return next.unsafeCast<Int>()
  }

/**
 * Returns a new unique DOM element ID.
 *
 * Guarantees 2^53-1 sequential IDs, good for 28 million IDs per second over a period of ten years.
 */
@KMDCInternalAPI
public fun uniqueDomElementId(): String = "kmdc-$nextDomElementId"

/**
 * Returns a new unique DOM element ID and remembers it between recompositions.
 *
 * Guarantees 2^53-1 sequential IDs, good for 28 million IDs per second over a period of ten years.
 */
@Composable
@KMDCInternalAPI
public inline fun rememberUniqueDomElementId(suffix: String? = null): String =
  remember { uniqueDomElementId() + (suffix?.let { "-$it" } ?: "") }

@Composable
@KMDCInternalAPI
public inline fun <T> rememberMutableStateOf(initial: T): MutableState<T> = remember { mutableStateOf(initial) }

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  vararg keys: Any?,
  effect: Builder<MDC>
) {
  DisposableEffect(*keys) {
    scopeElement.mdc(effect)
    onDispose { }
  }
}

@Composable
@KMDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  setter: MDC.(V) -> Unit
) {
  MDCSideEffect<MDC>(value) {
    setter(value)
  }
}

@Composable
@KMDCInternalAPI
public inline fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
) {
  MDCSideEffect(value, property::set)
}
