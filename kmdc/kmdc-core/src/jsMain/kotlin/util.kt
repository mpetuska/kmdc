@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.reflect.KMutableProperty1
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.events.Event

public typealias Builder<T> = T.() -> Unit
public typealias AttrsBuilder<T> = Builder<AttrsScope<T>>
public typealias ComposableBuilder<T> = @Composable Builder<T>
public typealias ContentBuilder<T> = ComposableBuilder<ElementScope<T>>

/**
 * Implies [ComposableBuilder] lambda as a parent [ContentBuilder] lambda, converting implicit [ElementScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver lambda to rescope
 * @return rescoped lambda that implies [T] on invocation
 */
@MDCInternalAPI
public inline fun <E : Element, T : ElementScope<E>> ComposableBuilder<T>.imply(): ContentBuilder<E> {
  return let { { unsafeCast<T>().it() } }
}

/**
 * Applies [Builder]<[T]> to [AttrsBuilder]<[E]>, converting implicit [AttrsScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 */
@MDCInternalAPI
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
@MDCInternalAPI
public inline fun <E : Element, T : ElementScope<E>> ElementScope<E>.applyContent(noinline block: ComposableBuilder<T>?) {
  block?.invoke(unsafeCast<T>())
}

@MDCInternalAPI
public abstract external class MDCEvent<T> : Event {
  public var detail: T
}

@MDCInternalAPI
private var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@MDCInternalAPI
public fun <T> Element.mdc(action: Builder<T>? = null): T? = mdc.unsafeCast<T?>()?.also { action?.invoke(it) }

@MDCInternalAPI
public inline fun <T : Any> jsObject(builder: Builder<T> = { }): T =
  js("({})").unsafeCast<T>().apply(builder)

@MDCInternalAPI
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

private var nextDomElementId = 0

/**
 * Returns a new unique DOM element ID.
 *
 * Guarantees 2^53-1 sequential IDs, good for 28 million IDs per second over a period of ten years.
 */
@MDCInternalAPI
public fun uniqueDomElementId(): String = "kmdc-${nextDomElementId++}"

@Composable
@MDCInternalAPI
public inline fun rememberUniqueDomElementId(suffix: String? = null): String =
  remember { uniqueDomElementId() + (suffix?.let { "-$it" } ?: "") }

@Composable
@MDCInternalAPI
public inline fun <T> rememberMutableStateOf(initial: T): MutableState<T> = remember { mutableStateOf(initial) }

@Composable
@MDCInternalAPI
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
@MDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  setter: MDC.(V) -> Unit
) {
  MDCSideEffect<MDC>(value) {
    setter(value)
  }
}

@Composable
@MDCInternalAPI
public inline fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
) {
  MDCSideEffect(value, property::set)
}
