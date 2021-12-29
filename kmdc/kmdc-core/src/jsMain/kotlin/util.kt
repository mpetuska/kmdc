package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event

@DslMarker
public annotation class MDCDsl

@DslMarker
public annotation class MDCAttrsDsl

public typealias Builder<T> = T.() -> Unit
public typealias ComposableBuilder<T> = @Composable Builder<T>

public external interface Destroyable {
  public fun destroy()
}

public abstract external class MDCEvent<T> : Event {
  public var detail: T
}

public var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

public fun <T> Element.mdc(action: Builder<T>? = null): T? = mdc.unsafeCast<T?>()?.also { action?.invoke(it) }

public inline fun <T : Any> jsObject(builder: Builder<T> = { }): T =
  js("({})").unsafeCast<T>().apply(builder)

@MDCAttrsDsl
public fun <T> AttrsBuilder<out HTMLElement>.initialiseMDC(mdcInit: (HTMLElement) -> T, onDispose: Builder<T>? = null) {
  ref {
    it.mdc = mdcInit(it)
    onDispose {
      it.mdc(onDispose)
    }
  }
}

@MDCAttrsDsl
public fun <T : Destroyable> AttrsBuilder<out HTMLElement>.initialiseMDC(mdcInit: (HTMLElement) -> T) {
  initialiseMDC(mdcInit, Destroyable::destroy)
}
