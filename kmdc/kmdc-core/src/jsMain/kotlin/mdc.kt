@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@KMDCInternalAPI
internal var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> Element.mdc(action: MDCAttrs<MDC>? = null): MDC? =
  mdc.unsafeCast<MDC?>()?.also { action?.invoke(it) }

private val MDCLocal = compositionLocalOf<Any?> { }

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
public inline fun <MDC : MDCBaseModule.MDCComponent<*>> MDCProviderScope<MDC>.withMDC(crossinline action: Builder<MDC>) {
  dev.petuska.kmdc.core.withMDC<MDC> { action() }
}

@KMDCInternalAPI
public inline val <MDC : MDCBaseModule.MDCComponent<*>> MDCProviderScope<MDC>.localMDC: MDC?
  @Suppress("UNCHECKED_CAST")
  @Composable
  get() = localMDC()

@Composable
@KMDCInternalAPI
public inline fun <MDC : MDCBaseModule.MDCComponent<*>> withMDC(action: Builder<MDC>) {
  localMDC<MDC>()?.apply(action)
}

@Composable
@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> localMDC(): MDC? {
  @Suppress("UNCHECKED_CAST")
  return MDCLocal.current?.let { it as? MDC }
}
