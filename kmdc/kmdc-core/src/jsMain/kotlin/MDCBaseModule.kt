package dev.petuska.kmdc.core

@JsModule("@material/base")
public external object MDCBaseModule {
  public abstract class MDCComponent<F> : Destroyable {
    override fun destroy()
    public fun initialize(vararg _args: Any?)
    public fun initialSyncWithDOM()
    public fun getDefaultFoundation(): F
    public val foundation: F
  }
}
