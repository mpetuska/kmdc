package dev.petuska.kmdc.core

import androidx.compose.runtime.Composable
import org.w3c.dom.Element

@JsName("require")
public external fun requireJsModule(module: String): dynamic

@DslMarker
public annotation class MDCDsl

@DslMarker
public annotation class MDCAttrsDsl

public typealias Builder<T> = T.() -> Unit
public typealias ComposableBuilder<T> = @Composable Builder<T>

public data class Wrapper<T>(val value: T)

public fun <T> T.wrap(): Wrapper<T> = Wrapper(this)

public var Element.mdc: dynamic
  get() = asDynamic().mdc
  set(value) {
    asDynamic().mdc = value
  }

public fun <T> Element.mdc(action: Builder<T>? = null): T? = mdc.unsafeCast<T?>()?.also { action?.invoke(it) }

@Suppress("NOTHING_TO_INLINE")
public inline fun <T : Any> jsObject(): T =
  js("({})")

public inline fun <T : Any> jsObject(builder: T.() -> Unit): T =
  jsObject<T>().apply(builder)
