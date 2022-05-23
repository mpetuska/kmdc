package dev.petuska.kmdc.core

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*
import kotlin.reflect.*

/**
 * A side effect based on [DisposableEffect] that uses [mdcInit] to initialise the [MDCBaseModule.MDCComponent]
 * once the element enters the composition and then destroy it once it leaves the composition.
 *
 * @receiver element scope providing access to native DOM element
 * @param mdcInit component provider
 * @param onDispose to further cleanup the removed component
 * @param keys to control the effect lifecycle
 */
@Composable
@KMDCInternalAPI
public fun <E : Element, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<E>.MDCInitEffect(
  mdcInit: (E) -> MDC,
  vararg keys: Any?,
  onDispose: (MDC.(E) -> Unit)? = null,
) {
  DisposableEffect(keys = keys) {
    scopeElement.mdc<MDC> { destroy() }
    scopeElement.mdc = mdcInit(scopeElement)
    onDispose {
      scopeElement.mdc<MDC> {
        onDispose?.invoke(this, scopeElement)
        destroy()
      }
    }
  }
}

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  vararg keys: Any?,
  onDispose: Builder<MDC>? = null,
  effect: Builder<MDC>
) {
  var mdc by rememberMutableStateOf<MDC?>(null)
  DisposableEffect(keys = keys + mdc) {
    mdc = scopeElement.mdc as MDC?
    scopeElement.mdc(effect)
    onDispose {
      scopeElement.mdc(onDispose)
    }
  }
}

@Composable
@KMDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCStateEffect(
  value: V,
  setter: MDC.(V) -> Unit
): Unit = MDCSideEffect<MDC>(value) { setter(value) }

@Composable
@KMDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCStateEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
): Unit = MDCStateEffect(value, property::set)

@Composable
@KMDCInternalAPI
public inline fun <reified MDC : MDCBaseModule.MDCComponent<*>> MDCSideEffectNew(
  vararg keys: Any?,
  noinline onDispose: Builder<MDC>? = null,
  crossinline effect: Builder<MDC>
) {
  val mdc = localMDC<MDC>()
  DisposableEffect(keys = keys + mdc) {
    mdc?.effect()
    onDispose {
      if (onDispose != null) {
        mdc?.onDispose()
      }
    }
  }
}

@Composable
@KMDCInternalAPI
public inline fun <reified MDC : MDCBaseModule.MDCComponent<*>> MDCProviderScope<MDC>.MDCSideEffectNew(
  vararg keys: Any?,
  noinline onDispose: Builder<MDC>? = null,
  crossinline effect: Builder<MDC>
) {
  dev.petuska.kmdc.core.MDCSideEffectNew(keys = keys, onDispose = onDispose, effect = effect)
}

@Composable
@KMDCInternalAPI
public inline fun <V, reified MDC : MDCBaseModule.MDCComponent<*>> MDCStateEffectNew(
  value: V,
  crossinline setter: MDC.(V) -> Unit
): Unit = MDCSideEffectNew<MDC>(value) { setter(value) }

@Composable
@KMDCInternalAPI
public inline fun <V, reified MDC : MDCBaseModule.MDCComponent<*>> MDCStateEffectNew(
  value: V,
  property: KMutableProperty1<MDC, V>
): Unit = MDCStateEffectNew(value, property::set)

/**
 * Synchronises the [value] to the [property] whenever the value changes and is not null.
 * @param value to synchronise
 * @param property to manage
 */
@Composable
@KMDCInternalAPI
public inline fun <V : Any, reified MDC : MDCBaseModule.MDCComponent<*>> MDCOptionalStateEffectNew(
  value: V?,
  property: KMutableProperty1<MDC, V>
): Unit = MDCSideEffectNew<MDC>(value) {
  value?.let { property.set(this, it) }
}
