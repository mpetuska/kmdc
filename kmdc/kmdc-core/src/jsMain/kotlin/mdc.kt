@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@KMDCInternalAPI
private var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

@KMDCInternalAPI
public fun <MDC : MDCBaseModule.MDCComponent<*>> Element.mdc(action: Builder<MDC>? = null): MDC? =
  mdc.unsafeCast<MDC?>()?.also { action?.invoke(it) }

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
 * A side effect based on [DisposableEffect] that uses [mdcInit] to initialise the [MDCBaseModule.MDCComponent]
 * once the element enters the composition and then destroy it once it leaves the composition.
 *
 * @receiver element scope providing access to native DOM element
 * @param mdcInit component provider
 * @param onDispose to further cleanup the removed component
 * @param keys to control the component lifecycle
 * @param setup to configure the created component
 */
@Composable
@KMDCInternalAPI
public fun <E : Element, MDC : MDCBaseModule.MDCComponent<*>> ElementScope<E>.MDCInitEffect(
  mdcInit: (E) -> MDC,
  onDispose: (MDC.(E) -> Unit)? = null,
  keys: Array<Any?> = arrayOf(Unit),
  rebuildOnChange: Boolean = false,
  setup: (MDC.(E) -> Unit)? = null,
) {
  DisposableEffect(keys = keys) {
    scopeElement.mdc = scopeElement.mdc
    if (scopeElement.mdc == null || rebuildOnChange) {
      if (rebuildOnChange) scopeElement.mdc<MDC> { destroy() }
      scopeElement.mdc = mdcInit(scopeElement)
    }

    setup?.invoke(scopeElement.mdc as MDC, scopeElement)
    onDispose {
      scopeElement.mdc<MDC> {
        destroy()
        onDispose?.invoke(this, scopeElement)
      }
    }
  }
}
