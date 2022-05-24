@file:JsModule("@material/base")

package dev.petuska.kmdc.core

@MDCExternalAPI
public abstract external class MDCComponent<F> {
  public fun destroy()
  public fun initialize(vararg args: Any?)
  public fun initialSyncWithDOM()
  public fun getDefaultFoundation(): F
  public val foundation: F
}
