package dev.petuska.kmdc.core

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@KMDCInternalAPI
private val MDCLocal: ProvidableCompositionLocal<MDCBaseModule.MDCComponent<*>?> = strictCompositionLocalOf()

@KMDCInternalAPI
public external interface MDCProviderScope<MDC : MDCBaseModule.MDCComponent<*>>

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>, E : Element> ElementScope<E>.MDCProvider(
  init: (E) -> MDC,
  vararg keys: Any?,
  onDispose: (MDC.(E) -> Unit)? = null,
  content: @Composable Builder<MDCProviderScope<MDC>>
) {
  var mdc by rememberMutableStateOf<MDC?>(null)
  DisposableEffect(keys = keys) {
    mdc?.run { destroy() }
    mdc = init(scopeElement)
    scopeElement.mdc = mdc
    onDispose {
      mdc?.run {
        onDispose?.invoke(this, scopeElement)
        destroy()
      }
    }
  }
  CompositionLocalProvider(MDCLocal provides mdc) {
    applyContent(content)
  }
}

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> localMDC(): MDC? {
  @Suppress("UNCHECKED_CAST")
  return MDCLocal.current?.let { it as? MDC }
}

@KMDCInternalAPI
public inline val <MDC : MDCBaseModule.MDCComponent<*>> MDCProviderScope<MDC>.localMDC: MDC?
  @Composable
  get() = localMDC()
