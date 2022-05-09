package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import org.jetbrains.compose.web.dom.ElementScope
import kotlin.reflect.KMutableProperty1

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  vararg keys: Any?,
  onDispose: Builder<MDC>? = null,
  effect: Builder<MDC>
) {
  DisposableEffect(keys = keys) {
    scopeElement.mdc(effect)
    onDispose {
      scopeElement.mdc(onDispose)
    }
  }
}

@Composable
@KMDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  setter: MDC.(V) -> Unit
): Unit = MDCSideEffect<MDC>(value) { setter(value) }

@Composable
@KMDCInternalAPI
public fun <V, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<*>.MDCSideEffect(
  value: V,
  property: KMutableProperty1<MDC, V>
): Unit = MDCSideEffect(value, property::set)
