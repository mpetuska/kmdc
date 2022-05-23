package dev.petuska.kmdc.core

import androidx.compose.runtime.*
import kotlinx.browser.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public typealias AttrsBuilder<T> = AttrBuilderContext<T>
public typealias ContentBuilder<T> = org.jetbrains.compose.web.dom.ContentBuilder<T>
public typealias MDCAttrsRaw<T> = @MDCAttrsDsl AttrsBuilder<T>
public typealias MDCContentRaw<T> = @MDCDsl ContentBuilder<T>
public typealias Builder<T> = T.() -> Unit
public typealias MDCAttrs<T> = @MDCAttrsDsl Builder<T>
public typealias MDCContent<T> = @Composable @MDCDsl Builder<T>

/**
 * Reinterprets [MDCContent] lambda as a parent [ContentBuilder] lambda,
 * converting implicit [ElementScope]<[E]> to [S] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver lambda to reinterpret
 * @return reinterpreted lambda that implies [S] on invocation
 */
@KMDCInternalAPI
public fun <S : ElementScope<E>, E : Element> MDCContent<S>?.reinterpret(): ContentBuilder<E>? {
  return this?.let { { unsafeCast<S>().it() } }
}

/**
 * Reinterprets [MDCContent] lambda as a parent [ContentBuilder] lambda,
 * converting implicit [ElementScope]<[E]> to [S] via [scope] provider.
 * This is safe and can be used for uncontrolled scope types which have member properties or functions.
 * @receiver lambda to reinterpret
 * @param scope provider
 * @return reinterpreted lambda that implies [S] on invocation
 */
@KMDCInternalAPI
public inline fun <S : ElementScope<E>, E : Element> MDCContent<S>?.reinterpret(crossinline scope: (ElementScope<E>) -> S): ContentBuilder<E>? {
  return this?.let { { scope(this).it() } }
}

/**
 * Applies [MDCAttrs]<[T]> to [AttrsBuilder]<[E]>, converting implicit [AttrsScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 */
@KMDCInternalAPI
public fun <E : Element, T : AttrsScope<E>> AttrsScope<E>.applyAttrs(block: MDCAttrs<T>?) {
  block?.invoke(unsafeCast<T>())
}

/**
 * Applies [MDCContent]<[T]> to [ContentBuilder]<[E]>, converting implicit [ElementScope]<[E]> to [T] via [unsafeCast].
 * This should only be used for controlled scope types which do not have any member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 */
@Composable
@KMDCInternalAPI
public fun <E : Element, T : ElementScope<E>> ElementScope<E>.applyContent(block: MDCContent<T>?) {
  block?.invoke(unsafeCast<T>())
}

/**
 * Applies [MDCContent]<[T]> to [ContentBuilder]<[E]>, converting implicit [ElementScope]<[E]> to [T] via [scope] provider.
 * This is safe and can be used for uncontrolled scope types which have member properties or functions.
 * @receiver scope to apply [block] to
 * @param block to imply and apply
 * @param scope provider
 */
@Composable
@KMDCInternalAPI
public inline fun <E : Element, T : ElementScope<E>> ElementScope<E>.applyContent(
  noinline block: MDCContent<T>?,
  scope: (ElementScope<E>) -> T
) {
  block?.let { scope(this).it() }
}

@KMDCInternalAPI
public inline fun <T : Any> jsObject(builder: MDCAttrs<T> = { }): T = js("({})").unsafeCast<T>().apply(builder)

internal val kmdcCounterKey = "_kmdcCounter" // NEVER EVER CHANGE THIS

/**
 * We're hooking it up to global context to avoid duplicate counters
 * in case multiple kmdc versions somehow make it into the same project
 */
private val nextDomElementId: Int
  get() {
    val dynamicWindow = window.asDynamic()
    val next = (dynamicWindow[kmdcCounterKey] ?: 0) + 1
    dynamicWindow[kmdcCounterKey] = next
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
public fun rememberUniqueDomElementId(suffix: String? = null): String =
  remember { uniqueDomElementId() + (suffix?.let { "-$it" } ?: "") }

@Composable
@KMDCInternalAPI
public fun <T> rememberMutableStateOf(initial: T): MutableState<T> = remember { mutableStateOf(initial) }

public fun <T> strictCompositionLocalOf(): ProvidableCompositionLocal<T> = compositionLocalOf { error("undefined") }
