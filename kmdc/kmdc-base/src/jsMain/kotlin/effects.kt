package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import kotlin.reflect.KMutableProperty1

@Composable
@KMDCInternalAPI
public inline fun <reified MDC : MDCComponent<*>> MDCSideEffect(
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
public inline fun <reified MDC : MDCComponent<*>> MDCProviderScope<MDC>.MDCSideEffect(
  vararg keys: Any?,
  noinline onDispose: Builder<MDC>? = null,
  crossinline effect: Builder<MDC>
) {
  dev.petuska.kmdc.core.MDCSideEffect(keys = keys, onDispose = onDispose, effect = effect)
}

@Composable
@KMDCInternalAPI
public inline fun <V, reified MDC : MDCComponent<*>> MDCStateEffect(
  value: V,
  crossinline setter: MDC.(V) -> Unit
): Unit = MDCSideEffect<MDC>(value) { setter(value) }

@Composable
@KMDCInternalAPI
public inline fun <V, reified MDC : MDCComponent<*>> MDCProviderScope<MDC>.MDCStateEffect(
  value: V,
  crossinline setter: MDC.(V) -> Unit
) {
  dev.petuska.kmdc.core.MDCStateEffect(value = value, setter = setter)
}

@Composable
@KMDCInternalAPI
public inline fun <V, reified MDC : MDCComponent<*>> MDCStateEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
): Unit = MDCStateEffect(value, property::set)

/**
 * Synchronises the [value] to the [property] whenever the value changes and is not null.
 * @param V
 * @param MDC
 * @param value to synchronise
 * @param property to manage
 */
@Composable
@KMDCInternalAPI
public inline fun <V : Any, reified MDC : MDCComponent<*>> MDCOptionalStateEffect(
  value: V?,
  property: KMutableProperty1<MDC, V>
): Unit = MDCSideEffect<MDC>(value) {
  value?.let { property.set(this, it) }
}
