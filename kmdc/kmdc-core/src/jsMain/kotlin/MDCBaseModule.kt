package dev.petuska.kmdc.core

@MDCExternalAPI
@JsModule("@material/base")
public external object MDCBaseModule {
  public abstract class MDCComponent<F> {
    public fun destroy()
    public fun initialize(vararg _args: Any?)
    public fun initialSyncWithDOM()
    public fun getDefaultFoundation(): F
    public val foundation: F
  }
}
